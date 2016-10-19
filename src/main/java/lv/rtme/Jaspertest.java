/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme;

import java.util.HashMap;
import java.util.Map;
import lv.rtme.entities.TestBeany;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class Jaspertest {
    
    public static void main(String[] args) throws JRException {
        
        TestBeany[] myBeans = new TestBeany[1];
        
        
       myBeans[0]=new TestBeany("Мой охеренный текст");
        
        JRAbstractBeanDataSource beanDataSource = new JRBeanArrayDataSource(myBeans, false);
       
       
        Map<String,Object> params = new HashMap<>();
        
      JasperPrint jasperPrint = JasperFillManager.fillReport("C:\\Users\\Maksims\\Documents\\NetBeansProjects\\lv\\rtme\\railboot\\src\\main\\resources\\testingJR.jasper", params, beanDataSource);
      
      
      JRPdfExporter exporter = new JRPdfExporter();
//        JRViewer view = new JRViewer(jasperPrint);
//        
//        view.setVisible(true);
        
        JasperViewer viewer = new JasperViewer(jasperPrint);
    viewer.setVisible(true);
    
        JasperPrintManager.printReport(jasperPrint, true);
    }
 

}
