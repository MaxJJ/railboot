/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import static javassist.bytecode.InstructionPrinter.print;
import lv.rtme.entities.Points;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

/**
 *
 * @author User
 */
public class Jaspertest {
    
    public static void main(String[] args) throws JRException {
        
        Points[] myBeans = new Points[1];
        myBeans[0]=new Points("станция","Рига-Краста","098654");
        
        JRAbstractBeanDataSource beanDataSource = new JRBeanArrayDataSource(myBeans, true);
        
        Map<String,Object> params = new HashMap<>();
        
      JasperPrint jasperPrint = JasperFillManager.fillReport("C:\\Users\\User\\Documents\\NetBeansProjects\\railboot\\src\\main\\resources\\Blank_A4.jasper", params, beanDataSource);
      
      
      JRPdfExporter exporter = new JRPdfExporter();
//          exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//          exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
//          SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
//          
//          configuration.setPermissions(PdfWriter.AllowCopy | PdfWriter.AllowPrinting);
//          exporter.setConfiguration(configuration);
exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream(reportName + ".pdf")); // your output goes here
          exporter.exportReport();
    
    }
 

}
