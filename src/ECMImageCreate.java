import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import coupleapp.main.Base64;
import Documents.Office.Poi.ApachePoitImageCreate;


/**
* ##################################################
* 
Result
PDF파일 총페이지 수 : 24
Writing: C:\image\2.pdf_1.png
Writing: C:\image\2.pdf_2.png
Writing: C:\image\2.pdf_3.png
Writing: C:\image\2.pdf_4.png
Writing: C:\image\2.pdf_5.png
Writing: C:\image\2.pdf_6.png
Writing: C:\image\2.pdf_7.png
Writing: C:\image\2.pdf_8.png
Writing: C:\image\2.pdf_9.png
Writing: C:\image\2.pdf_10.png
Writing: C:\image\2.pdf_11.png
Writing: C:\image\2.pdf_12.png
Writing: C:\image\2.pdf_13.png
Writing: C:\image\2.pdf_14.png
Writing: C:\image\2.pdf_15.png
Writing: C:\image\2.pdf_16.png
Writing: C:\image\2.pdf_17.png
Writing: C:\image\2.pdf_18.png
Writing: C:\image\2.pdf_19.png
Writing: C:\image\2.pdf_20.png
Writing: C:\image\2.pdf_21.png
Writing: C:\image\2.pdf_22.png
Writing: C:\image\2.pdf_23.png
Writing: C:\image\2.pdf_24.png
* ##################################################
* 
* 
*   if(sourcefileExtension.toLowerCase().equals("ppt"))			ApachePotImageCreatePPT(type);
		if(sourcefileExtension.toLowerCase().equals("pptx"))		ApachePotImageCreatePPTX(type);
		if(sourcefileExtension.toLowerCase().equals("pdf"))		    ApachePotImageCreatePDF(type);
* 
*/
public class ECMImageCreate 
{
	/**
	* ##################################################
	* 
	- 썸네일 및 미리보기 이미지 리스트 (최대5장)
	- 경로 : /WAS/DATA/ES/DocumentPreview/ECM/ 폴더 아래 문서ID/밑에 base64 인코딩된 txt 읽음
	- 화면 로직
 	. 추천포틀릿에서 ECM 문서라면, 아래 NAS 경로내 디렉토리가 존재하는지 보고 존재한다면 폴더내 텍스트 Read
 	. 썸네일 보여줄때는 문서ID_1.txt 로 노출
 	. 미리보기 팝업 연계시 해당 폴더내 .txt 수만큼 노출 (최대 5개이고 작을수도 있음)
  	
  	예) /WAS/DATA/ES/DocumentPreview/ECM/doc0900bf4000123/0900bf4000123_1.txt 형태
	*   if(sourcefileExtension.toLowerCase().equals("ppt"))			ApachePotImageCreatePPT(type);
 		if(sourcefileExtension.toLowerCase().equals("pptx"))		ApachePotImageCreatePPTX(type);
 		if(sourcefileExtension.toLowerCase().equals("pdf"))		    ApachePotImageCreatePDF(type);
	* 
	*/
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub

		String filename="tmp_0900bf4b9c2335d5_0900bf4b9c2335d5_1502973584185.pdf";
		String source = "C:\\" + filename;
		String target = "D:\\";
		
		String match = "[^\\uAC00-\\uD7A3xfe0-9a-zA-Z\\s\\.\\r\\n|\\r|\\n|\\n\\r|^\\u2460-\\u2473|^\\u3250-\\u325F|^\\u32B1-\\u32BF]";
		
		String test = "①②③④⑤⑥⑦⑧⑨⑩⑪⑫⑬⑭⑮⑯⑰⑱⑲⑳";  
		
		test = test.toString().replaceAll("(\r\n|\r|\n|\n\r)", " ").replaceAll(match, "").replaceAll("\\p{Space}", " ")
		.replaceAll("( )+", " ").replaceAll("\\[", "")
		.replaceAll("\\^", "").replaceAll("\\@", "")
		.replaceAll("\\'", "").replaceAll("\'", "").replaceAll("\\\"", "")
		.replaceAll("\"", "").replaceAll("null", "");
		
		test = test.toString().replaceAll("&amp;", "&").replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>","")
		.replaceAll("<(/)?([\\?])?([a-zA-Z]*(=)?(:)?[^>]*)?(\\s)*(/)?>","").replaceAll("&amp;", "").replaceAll("&nbsp;", "").replaceAll("&lt;", "")
		.replaceAll("&gt;", "").replaceAll("&amp", "").replaceAll("&nbsp", "").replaceAll("&lt", "").replaceAll("&gt", "")
		.replaceAll("", "").replaceAll("\"", "").replaceAll("‘", "").replaceAll("’", "").replaceAll("\r\n", "").replaceAll("\n", "").replaceAll("/[\r|\n]/g", "")
		.replaceAll("</[pP]>", "").replaceAll("<(/)?[bB][rR](\\s)*(/)?>", "").replaceAll("[\\x00-\\x09\\x11\\x12\\x14-\\x1F\\x7F]", "");
		
		System.out.println(test);
//		new ApachePoitImageCreate(source, target, filename).CommonImageMain("png");
		
//		convertTextToGraphic();
	}
	
	public static void convertTextToGraphic() {

		String text1 = "Hello";

        /*
           Because font metrics is based on a graphics context, we need to create
           a small, temporary image so we can ascertain the width and height
           of the final image
         */
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font1 = new Font("Arial", Font.PLAIN, 48);
        g2d.setFont(font1);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(text1);
        int height = fm.getHeight();
        g2d.dispose();

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font1);
        fm = g2d.getFontMetrics();
        g2d.setColor(Color.BLACK);
        g2d.drawString(text1, 0, fm.getAscent());
        g2d.dispose();
        try {
            ImageIO.write(img, "png", new File("D:\\Text.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
	
	
}
