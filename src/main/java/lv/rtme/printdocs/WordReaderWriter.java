/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.printdocs;


import java.io.FileOutputStream;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.OPOIFSFileSystem;
import org.apache.poi.poifs.property.DirectoryProperty;
import static org.apache.poi.sl.draw.binding.STRectAlignment.CTR;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import static org.openxmlformats.schemas.drawingml.x2006.main.STPenAlignment.CTR;
import static org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType.CTR;
import static org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType.CTR;
import static org.openxmlformats.schemas.drawingml.x2006.main.STTextFontAlignType.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;


/**
 *
 * @author User
 */
public class WordReaderWriter {
      public static void main(String[] args) {
        try {
            // создаем модель docx документа, 
            // к которой будем прикручивать наполнение (колонтитулы, текст)
            XWPFDocument docxModel = new XWPFDocument();
            CTSectPr ctSectPr = docxModel.getDocument().getBody().addNewSectPr();
            // получаем экземпляр XWPFHeaderFooterPolicy для работы с колонтитулами
            XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(docxModel, ctSectPr);
 
            // создаем верхний колонтитул Word файла
            CTP ctpHeaderModel = createHeaderModel(
            "Верхний колонтитул - создано с помощью Apache POI на Java :)"
            );
            // устанавливаем сформированный верхний
            // колонтитул в модель документа Word
            XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeaderModel, docxModel);
            headerFooterPolicy.createHeader(
                    XWPFHeaderFooterPolicy.DEFAULT,
                    new XWPFParagraph[]{headerParagraph}
            );
 
            // создаем нижний колонтитул docx файла
            CTP ctpFooterModel = createFooterModel("Просто нижний колонтитул");
            // устанавливаем сформированый нижний
            // колонтитул в модель документа Word
            XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooterModel, docxModel);
            headerFooterPolicy.createFooter(
                    XWPFHeaderFooterPolicy.DEFAULT,
                    new XWPFParagraph[]{footerParagraph}
            );
 
            // создаем обычный параграф, который будет расположен слева,
            // будет синим курсивом со шрифтом 25 размера
            XWPFParagraph bodyParagraph = docxModel.createParagraph();
            bodyParagraph.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun paragraphConfig = bodyParagraph.createRun();
            paragraphConfig.setItalic(true);
            paragraphConfig.setFontSize(25);
            // HEX цвет без решетки #
            paragraphConfig.setColor("06357a");
            paragraphConfig.setText(
            "Prologistic.com.ua - новые статьи по Java и Android каждую неделю. Подписывайтесь!"
            );
 
            // сохраняем модель docx документа в файл
            FileOutputStream outputStream = new FileOutputStream("C:/Users/User/Desktop/Apache POI Word Test.docx");
            docxModel.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Успешно записан в файл");
    }
 
    private static CTP createFooterModel(String footerContent) {
        // создаем футер или нижний колонтитул
        CTP ctpFooterModel = CTP.Factory.newInstance();
        CTR ctrFooterModel = ctpFooterModel.addNewR();
        CTText cttFooter = ctrFooterModel.addNewT();
 
        cttFooter.setStringValue(footerContent);
        return ctpFooterModel;
    }
 
    private static CTP createHeaderModel(String headerContent) {
        // создаем хедер или верхний колонтитул
        CTP ctpHeaderModel = CTP.Factory.newInstance();
        CTR ctrHeaderModel = ctpHeaderModel.addNewR();
        CTText cttHeader = ctrHeaderModel.addNewT();
 
        cttHeader.setStringValue(headerContent);
        return ctpHeaderModel;
    }
    
}
