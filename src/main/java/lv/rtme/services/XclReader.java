/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component
@Scope
public class XclReader {
    
    @Value("${excl.url}")
    private String filePath;
    
    private XSSFWorkbook myExcelBook;
    private XSSFSheet myExcelSheet;
    
    public XclReader() {}
    
    
    public Set<String> getSetFromColumn(int column){
       Set<String> stations = new LinkedHashSet<>(); 
        for (int i = 2; i <= 202; i++) {
            stations.add(myExcelSheet.getRow(i).getCell(column, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
        }
        return stations;
    }
    
    public Map<Integer, Object> getRowAsMapBy(int row) {

        Map<Integer, Object> rowAsMap = new HashMap<>();
        XSSFRow nextRow = myExcelSheet.getRow(row);
        DataFormatter formatter = new DataFormatter();
        for (int i = 0; i <= 13; i++) {
            XSSFCell cell = nextRow.getCell(i, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            if (i == 13) {
                Date time = null;
                try {
                    time = cell.getDateCellValue();
                } catch (Exception e) {
                    time = new Date();
                    time.setTime(1L);
                }
                rowAsMap.put(i, time);
                break;
            }
            rowAsMap.put(i, formatter.formatCellValue(cell));

        }

        return rowAsMap;
    }

    @PostConstruct
	public void init() throws Exception {
	 
         myExcelBook = new XSSFWorkbook(new FileInputStream(filePath)); 
         myExcelSheet = myExcelBook.getSheet("ДАННЫЕ");            
	}
        
        @PreDestroy
        public void destroy() throws IOException{
            
            myExcelBook.close();
        }

    
    
        
       public  void readFromExcel() throws IOException {
               
      Set<String> stations = new LinkedHashSet<>(); 
      
      
      
      
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
