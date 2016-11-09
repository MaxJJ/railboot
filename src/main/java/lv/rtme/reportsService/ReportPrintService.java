/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.reportsService;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import lv.rtme.fxui.models.CodesOrderModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */

@Component

public class ReportPrintService {
    @Autowired
    private CodesOrderModel model;
    
    
    
    public void setModel(CodesOrderModel param){
        
        model=param;
    }
    
    
    public void printThis(){
        
          CodesOrderModel[] modelArray = new CodesOrderModel[1];
        modelArray[0]=model;
        System.out.println("array --"+modelArray[0].getFileID());
        System.out.println("model --"+model.getFileID());
        
        JRAbstractBeanDataSource beanDataSource = new JRBeanArrayDataSource(modelArray, false);
       
        Map<String,Object> params = new HashMap<>();
        
      JasperPrint jasperPrint = null;
        try {
//            jasperPrint = JasperFillManager.fillReport(getClass().getClassLoader().getResource("/codes_order.jasper").getFile(), params, beanDataSource);
        jasperPrint=JasperFillManager.fillReport(getClass().getClassLoader().getResource("codes_order.jasper").getFile(), params, beanDataSource);
        } catch (Exception ex) {
            
            System.out.println("JRException throw 1");
            Logger.getLogger(ReportPrintService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
//      JRPdfExporter exporter = new JRPdfExporter();
//        JRViewer view = new JRViewer(jasperPrint);
//        
//        view.setVisible(true);
        try {
            //        JasperViewer viewer = new JasperViewer(jasperPrint);
//    viewer.setVisible(true);
    
        JasperPrintManager.printReport(jasperPrint, false);
//JasperPrintManager.printPage(jasperPrint, 0, true);
        } catch (JRException ex) {
            System.out.println("Throw 2");
            Logger.getLogger(ReportPrintService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    
}
