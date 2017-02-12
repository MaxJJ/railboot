/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */

@Component

public class ReportPrintService {
    @Autowired
    private FileService fileService;
    
   @Value("${jsondox.url}")
   private String folder;
   @Value("${codesdocx.url}")
   private String doxFolder;
  
    
    public void printThis(String fileId)  {
      
   
           JasperPrint jrPrint = getJRprint("codes_order",fileId);
         
//           JRDocxExporter exporter = new JRDocxExporter();
           JRPdfExporter exporter = new JRPdfExporter();
           List<JasperPrint> jasperPrintList = new ArrayList<>();
           jasperPrintList.add(jrPrint);
           
           ExporterInput exporterInput = SimpleExporterInput.getInstance(jasperPrintList);
           
           OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(doxFolder+"\\"+fileId+".pdf");
           exporter.setExporterInput(exporterInput);
           exporter.setExporterOutput(exporterOutput);
        try {
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(ReportPrintService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       
    }

    private JRDataSource getJsonDataSource(String fileId) {
      JsonDataSource jsonDataSource = null;
       InputStream is = null;
      try {
            String path = "";
            path = path.concat(folder).concat("\\"+fileId+".json");
            is = new FileInputStream(new File(path));
            
            jsonDataSource= new JsonDataSource(is);
        } catch (FileNotFoundException | JRException ex) {
            Logger.getLogger(ReportPrintService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return jsonDataSource;
    }

    private JasperDesign getJasperDesign(String jrxmlName) {
        JasperDesign jasperDesign=null;
        try {
            jasperDesign= JRXmlLoader.load(fileService.getPath("jrxml")+"/"+jrxmlName+".jrxml");
        } catch (JRException ex) {
            Logger.getLogger(ReportPrintService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jasperDesign;
    }

    private JasperPrint getJRprint(String jrxmlName,String fileId) {
       JasperPrint print=null;
        try {
            JasperDesign jasperDesign = getJasperDesign(jrxmlName);
            JasperReport report = JasperCompileManager.compileReport(jasperDesign);
            
            String fld = fileService.getPath("jrxml") ;
            fld = fld.concat("/");
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("myPath", fld);
            JRDataSource dataSource =  getJsonDataSource(fileId);
            print= JasperFillManager.fillReport(report, parameters, dataSource);
            
           
        } catch (JRException ex) {
            Logger.getLogger(ReportPrintService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return print; 
    }
    
}
