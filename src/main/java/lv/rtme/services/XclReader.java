/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component
public class XclReader {
    
    @Value("${excl.url}")
    private String filePath;
    
    private XSSFWorkbook myExcelBook;
    private XSSFSheet myExcelSheet;
    private Set<String> stations = new LinkedHashSet<>();
    
    public XclReader() {
       
        
    }
    
    public Set<String> getSetFromColumn(int column){
      for (int i = 2; i <= 190; i++) {
                 
             stations.add(myExcelSheet.getRow(i).getCell(column).getStringCellValue());
                   
               }
                
        return stations;
    }
    
    @PostConstruct
	public void init() throws Exception {
	 
         myExcelBook = new XSSFWorkbook(new FileInputStream(filePath)); 
                     
	}
        

    
    
        
       public  void readFromExcel() throws IOException {
               
      
      myExcelSheet = myExcelBook.getSheet("ДАННЫЕ");
      
      
        XSSFRow row = myExcelSheet.getRow(2);
        
        if(row.getCell(2).getCellType() == XSSFCell.CELL_TYPE_STRING){
            String name = row.getCell(2).getStringCellValue();
            System.out.println("++++++++++++++++name : " + name);
        }
        
               for (int i = 2; i <= 190; i++) {
                 
             stations.add(myExcelSheet.getRow(i).getCell(2).getStringCellValue());
                   
               }
               for (String stat : stations) {
                   System.out.println(stat);
               }
        myExcelBook.close();
        
    }
    
    
}
