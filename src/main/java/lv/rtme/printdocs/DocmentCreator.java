/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.printdocs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author Maksims
 */
public class DocmentCreator {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
     
        XWPFDocument document = new XWPFDocument();
        if(new File("d:/testpoi.docx").exists()){
            Runtime.getRuntime().exec(
            "cmd /c taskkill /f /im winword.exe");
        }
        File file = new File("d:/testpoi.docx");
        
        
        FileOutputStream outputStream = new FileOutputStream(file);
        
        XWPFParagraph paragraph =  document.createParagraph();
        
        XWPFRun run = paragraph.createRun();
        run.setText("Text From POI");
        
        
        document.write(outputStream);
        outputStream.close();
        
        
        
    }
    
}
