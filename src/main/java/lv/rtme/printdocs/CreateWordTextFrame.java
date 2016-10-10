/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.printdocs;

import java.io.FileOutputStream;
import java.math.BigInteger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFramePr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHAnchor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVAnchor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STWrap;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STXAlign;

/**
 *
 * @author Maksims
 */

    
    public class CreateWordTextFrame {

 public static void main(String[] args) throws Exception {

  XWPFDocument doc= new XWPFDocument();

  XWPFParagraph paragraph = doc.createParagraph();
  XWPFRun run=paragraph.createRun();  
  run.setText("The body text:");

  CTSdtContentBlock ctSdtContentBlock = doc.getDocument().getBody().addNewSdt().addNewSdtContent();

  CTP ctP = ctSdtContentBlock.addNewP();
  ctP.addNewR().addNewT().setStringValue("The TextFrame text...");

  CTPPr ctPPr = ctP.addNewPPr();
  CTFramePr ctFramePr = ctPPr.addNewFramePr();
  ctFramePr.setHAnchor(STHAnchor.TEXT);
  ctFramePr.setVAnchor(STVAnchor.TEXT);
  ctFramePr.setXAlign(STXAlign.CENTER);
  ctFramePr.setWrap(STWrap.NONE);
  ctFramePr.setY(BigInteger.ONE);
  ctFramePr.setW(BigInteger.valueOf(4000));
  ctFramePr.setHSpace(BigInteger.valueOf(400));

  CTPBdr ctPBdr = ctPPr.addNewPBdr();
  CTBorder ctBorder = ctPBdr.addNewLeft(); ctBorder.setColor("000000"); ctBorder.setVal(STBorder.SINGLE); ctBorder.setSz(BigInteger.valueOf(4)); ctBorder.setSpace(BigInteger.valueOf(7));
  ctBorder = ctPBdr.addNewRight(); ctBorder.setColor("000000"); ctBorder.setVal(STBorder.SINGLE); ctBorder.setSz(BigInteger.valueOf(4)); ctBorder.setSpace(BigInteger.valueOf(7));
  ctBorder = ctPBdr.addNewTop(); ctBorder.setColor("000000"); ctBorder.setVal(STBorder.SINGLE); ctBorder.setSz(BigInteger.valueOf(4)); ctBorder.setSpace(BigInteger.valueOf(7));
  ctBorder = ctPBdr.addNewBottom(); ctBorder.setColor("000000"); ctBorder.setVal(STBorder.SINGLE); ctBorder.setSz(BigInteger.valueOf(4)); ctBorder.setSpace(BigInteger.valueOf(7));

  paragraph = doc.createParagraph();
  run=paragraph.createRun();  
  run.setText("Lorem ipsum semit color ... Lorem ipsum semit color ... Lorem ipsum semit color ... Lorem ipsum semit color ... Lorem ipsum semit color ... Lorem ipsum semit color ... Lorem ipsum semit color ... Lorem ipsum semit color ... Lorem ipsum semit color ... Lorem ipsum semit color ... Lorem ipsum semit color ... Lorem ipsum semit color ... Lorem ipsum semit color ... Lorem ipsum semit color ... Lorem ipsum semit color ... Lorem ipsum semit color ... ");

  doc.write(new FileOutputStream("d:/WordTextFrame.docx"));

 }
}

