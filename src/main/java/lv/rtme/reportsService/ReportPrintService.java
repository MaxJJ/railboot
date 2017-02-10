/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.reportsService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import lv.rtme.fxui.models.CodesOrderModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.xml.JRParameterFactory;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.ExporterInputItem;
import net.sf.jasperreports.export.ExporterOutput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.ReportExportConfiguration;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleExporterInputItem;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */

@Component

public class ReportPrintService {
   @Value("${jsondox.url}")
   private String folder;
   @Value("${codesdocx.url}")
   private String doxFolder;
    
    public void printThis(String fileId) {
        InputStream is = null;
       try {
           String path = "";
           path = path.concat(folder).concat("\\"+fileId+".json");
           System.out.println(path);
           is = new FileInputStream(new File(path));
           System.out.println(getClass().getClassLoader().getResource("jrxml/codes_order.jrxml"));
           JasperDesign jasperDesign = JRXmlLoader.load(getClass().getClassLoader().getResource("jrxml/codes_order.jrxml").getFile());
         
           JasperReport report = JasperCompileManager.compileReport(jasperDesign);
           Map<String, Object> parameters = new HashMap<>();
           JRDataSource dataSource = new JsonDataSource(is);
           
           JasperPrint print= JasperFillManager.fillReport(report, parameters, dataSource);
       
         
           JRDocxExporter exporter = new JRDocxExporter();
           List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
           jasperPrintList.add(print);
           ExporterInput exporterInput = SimpleExporterInput.getInstance(jasperPrintList);
           OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(doxFolder+"\\"+fileId+".docx");
           exporter.setExporterInput(exporterInput);
           exporter.setExporterOutput(exporterOutput);
           exporter.exportReport();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(ReportPrintService.class.getName()).log(Level.SEVERE, null, ex);
       } catch (JRException ex) {
           Logger.getLogger(ReportPrintService.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           try {
               is.close();
           } catch (IOException ex) {
               Logger.getLogger(ReportPrintService.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        
       
       
    }
    
}
