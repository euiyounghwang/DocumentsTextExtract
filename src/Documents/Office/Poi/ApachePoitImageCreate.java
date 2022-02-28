package Documents.Office.Poi;
//
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDResources;
//import org.apache.pdfbox.rendering.ImageType;
//import org.apache.pdfbox.rendering.PDFRenderer;
//import org.apache.pdfbox.tools.imageio.ImageIOUtil;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Graphics2D;
//import java.awt.RenderingHints;
//import java.awt.geom.AffineTransform;
//import java.awt.geom.Point2D;
//import java.awt.geom.Rectangle2D;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import javax.imageio.ImageIO;
//
//import org.apache.poi.hslf.model.Slide;
//import org.apache.poi.hslf.usermodel.SlideShow;
//import org.apache.poi.xslf.usermodel.XMLSlideShow;
//import org.apache.poi.xslf.usermodel.XSLFSlide;
//
//import com.aspose.cells.Cell;
//import com.aspose.cells.Cells;
//import com.aspose.cells.ImageFormat;
//import com.aspose.cells.ImageOrPrintOptions;
//import com.aspose.cells.PageSetup;
//import com.aspose.cells.PdfCompliance;
//import com.aspose.cells.PdfSaveOptions;
//import com.aspose.cells.SaveFormat;
//import com.aspose.cells.SheetRender;
//import com.aspose.cells.Workbook;
//import com.aspose.cells.Worksheet;
//import com.aspose.words.Document;
//
//import Utils.ImageUtil;
//import coupleapp.main.Base64;

/**
* ##################################################
* Image Create
* ##################################################
*/
public class ApachePoitImageCreate 
{

//	private String sourceFile;
//	private String targetFile;
//	private String filename;
//	private String sourcefileExtension;
//	private String fileMode = "T";
// 
//	public ApachePoitImageCreate(String sourceFile, String targetFile, String filename) {
//		this.sourceFile = sourceFile;
//		this.targetFile = targetFile;
//		this.filename = filename;
//	}
//	
//	public void setFileMode(String fileMode) {
//		this.fileMode = fileMode;
//	}
//	
//
//	/**
//	* ##################################################
//	* Image Create
//	* docId.split(",")[_loop].substring(docId.split(",")[_loop].indexOf(";") + 1)
//	* ##################################################
//    */
//	public synchronized boolean CommonImageMain(String type) throws IOException 
//	{
//		System.out.println("ImageCreate Called ..");
//// 		sourcefileExtension = sourceFile.substring(sourceFile.indexOf(".") + 1).split(",")[0];
// 		sourcefileExtension = sourceFile.substring(sourceFile.indexOf(".") + 1).split(",")[0];
// 		System.out.println(sourcefileExtension);
//// 		
// 		if(sourcefileExtension.toLowerCase().equals("ppt")) {
// 			return ImageCreatePPT(type); 			
// 		}
////
// 		if(sourcefileExtension.toLowerCase().equals("pptx")) {
// 			return ImageCreatePPTX(type);
// 		}
//// 			
// 		if(sourcefileExtension.toLowerCase().equals("pdf"))	{
// 			return ImageCreatePDF(type);
// 		}
//// 		
// 		if(sourcefileExtension.toLowerCase().equals("docx")) {
// 			return ImageCreateDocx(type);
// 		}
//// 		
// 		if(sourcefileExtension.toLowerCase().equals("doc"))	{
// 			return ImageCreateDocx(type);
// 		}
// 		
// 		if(sourcefileExtension.toLowerCase().equals("xls"))		    {
// 			return ImageCreateXLS(type);
// 		}
// 		
// 		if(sourcefileExtension.toLowerCase().equals("xlsx"))	{
// 			return ImageCreateXLS(type);
// 		}
// 		
// 		if(sourcefileExtension.toLowerCase().equals("bmp") || sourcefileExtension.toLowerCase().equals("png") || sourcefileExtension.toLowerCase().equals("gif")
// 				 || sourcefileExtension.toLowerCase().equals("jpg") || sourcefileExtension.toLowerCase().equals("jpeg") || sourcefileExtension.toLowerCase().equals("psd")
// 				 || sourcefileExtension.toLowerCase().equals("tiff") || sourcefileExtension.toLowerCase().equals("svg"))	{
// 			return ImageCreateImg(type);
// 		}
// 		
// 		
//		return false;
//	}
//	
//	public synchronized boolean ImageCreateImg(String ImageType) throws IOException
//	{
//		File _source = null;
//		try
//		{
//			if ("F".equals(this.fileMode)) {
//				_source = new File(this.sourceFile);
//
//				ImageUtil.resize(_source, _source, 165, 103);
//			}
//
//			Base64.encodeFileToFile(this.sourceFile, this.targetFile + this.filename + ".txt");
//			return true;
//		}
//		catch (Exception localException) {
//		}
//		finally {
//			_source = null;
//
//			deleteFile(this.sourceFile);
//		}
//		return false;
//	}
//	
//	
//	
//	
//	public synchronized boolean ImageCreateXLS(String ImageType) throws IOException
//	{
//		System.out.println("ImageCreateXLS Called .." + this.sourceFile);
//	    try
//	    {
//	      Workbook book = new Workbook(this.sourceFile);
//
//	      ImageOrPrintOptions imgOptions = new ImageOrPrintOptions();
//
//	      imgOptions.setVerticalResolution(100);
//	      imgOptions.setHorizontalResolution(100);
//	      imgOptions.setQuality(100);
//
//	      imgOptions.setImageFormat(ImageFormat.getPng());
//
//	      imgOptions.setOnePagePerSheet(true);
//
//	      Worksheet sheet = null;
//
//	      if ("T".equals(this.fileMode))
//	      {
//	        sheet = book.getWorksheets().get(0);
//
//	        Cells cell = book.getWorksheets().get(0).getCells();
//
//	        int maxWidth = cell.getMaxColumn();
//	        int maxheight = cell.getMaxRow();
//
//	        int Width = 8;
//	        int height = 20;
//
//	        int StartWidth = 1;
//	        int Startheight = 1;
//
//	        String area = "";
//
//	        PageSetup pageSetup = sheet.getPageSetup();
//
//	        makeFolder(this.targetFile);
//
//	        for (int i = 0; i < 5; i++)
//	        {
//	          area = IntToLetters(StartWidth) + Startheight + ":" + IntToLetters(StartWidth + Width - 1) + (Startheight + height - 1);
//
//	          System.out.println("StartWidth = >" + StartWidth);
//
//	          if (StartWidth + Width > maxWidth) {
//	            StartWidth = 1;
//	            Startheight += height;
//	          }
//	          else
//	          {
//	            StartWidth += Width;
//	          }
//
//	          pageSetup.setPrintArea(area);
//
//	          SheetRender sr = new SheetRender(sheet, imgOptions);
//
//	          sr.toImage(0, this.targetFile + this.filename + "_" + i + "." + ImageType);
//
//	          Base64.encodeFileToFile(this.targetFile + this.filename + "_" + i + "." + ImageType, this.targetFile + this.filename + "_" + i + ".txt");
//
//	          deleteFile(this.targetFile + this.filename + "_" + i + "." + ImageType);
//
//	          if (Startheight > maxheight)
//	          {
//	            break;
//	          }
//	        }
//	      }
//	      else
//	      {
//	        for (int i = 0; i < book.getWorksheets().getCount(); i++)
//	        {
//	          sheet = book.getWorksheets().get(i);
//
//	          if ((!"pldt".equals(sheet.getName())) && (sheet.getVisibilityType() == 0)) {
//	            sheet = book.getWorksheets().get(i);
//	            break;
//	          }
//
//	        }
//
//	        PageSetup pageSetup = sheet.getPageSetup();
//
//	        pageSetup.setPrintArea("A1:F20");
//
//	        SheetRender sr = new SheetRender(sheet, imgOptions);
//
//	        System.out.println(this.targetFile + this.filename + "_0." + ImageType);
//
//	        sr.toImage(0, this.targetFile + this.filename + "_0." + ImageType);
//
//	        File _source = new File(this.targetFile + this.filename + "_0." + ImageType);
//
//	        ImageUtil.resize(_source, _source, 165, 103);
//
//	        Base64.encodeFileToFile(this.targetFile + this.filename + "_0." + ImageType, this.targetFile + this.filename + "_0" + ".txt");
//
//	        _source = null;
//	        deleteFile(this.targetFile + this.filename + "_0." + ImageType);
//	      }
//
//	      return true;
//	    }
//	    catch (Exception e)
//	    {
//	      e.printStackTrace();
//	    }
//	    return false;
//	}
//	
//	public synchronized boolean ImageCreateDocx(String ImageType) throws IOException
//	{
//	    System.out.println("ImageCreateDocx Called .." + this.sourceFile);
//	    try
//	    {
//	      Document doc = new Document(this.sourceFile);
//
//	      int THUMB_COLUMNS = 1;
//
//	      float SCALE = 1.0F;
//
//	      Dimension thumbSize = doc.getPageInfo(0).getSizeInPixels(SCALE, 96.0F);
//
//	      int imgWidth = (int)(thumbSize.getWidth() * 1.0D);
//	      int imgHeight = (int)thumbSize.getHeight();
//
//	      BufferedImage img = new BufferedImage(imgWidth, imgHeight, 2);
//
//	      Graphics2D gr = null;
//	      try
//	      {
//	        if ("T".equals(this.fileMode))
//	        {
//	          int length = 5;
//
//	          if (doc.getPageCount() < 5) {
//	            length = doc.getPageCount();
//	          }
//
//	          makeFolder(this.targetFile);
//
//	          for (int pageIndex = 0; pageIndex < length; pageIndex++)
//	          {
//	            gr = img.createGraphics();
//
//	            gr.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//
//	            gr.setColor(Color.white);
//
//	            gr.fillRect(0, 0, imgWidth, imgHeight);
//
//	            int rowIdx = pageIndex / 1;
//	            int columnIdx = pageIndex % 1;
//
//	            float thumbLeft = 0.0F;
//	            float thumbTop = 0.0F;
//
//	            Point2D.Float size = doc.renderToScale(pageIndex, gr, thumbLeft, thumbTop, SCALE);
//
//	            gr.setColor(Color.black);
//
//	            gr.drawRect((int)thumbLeft, (int)thumbTop, (int)size.getX(), (int)size.getY());
//
//	            ImageIO.write(img, ImageType, new File(this.targetFile + this.filename + "_" + pageIndex + "." + ImageType));
//
//	            Base64.encodeFileToFile(this.targetFile + this.filename + "_" + pageIndex + "." + ImageType, this.targetFile + this.filename + "_" + pageIndex + ".txt");
//
//	            deleteFile(this.targetFile + this.filename + "_" + pageIndex + "." + ImageType);
//	          }
//
//	        }
//	        else
//	        {
//	          int pageIndex = 0;
//
//	          int j = 0;
//	          if (doc.getPageCount() > 2) {
//	            j = 1;
//	          }
//
//	          gr = img.createGraphics();
//
//	          gr.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//
//	          gr.setColor(Color.white);
//
//	          gr.fillRect(0, 0, imgWidth, imgHeight);
//
//	          int rowIdx = j / 1;
//	          int columnIdx = j % 1;
//
//	          float thumbLeft = 0.0F;
//	          float thumbTop = 0.0F;
//
//	          Point2D.Float size = doc.renderToScale(j, gr, thumbLeft, thumbTop, SCALE);
//
//	          gr.setColor(Color.black);
//
//	          System.out.println((int)size.getX() + "     " + (int)size.getY());
//
//	          gr.drawRect((int)thumbLeft, (int)thumbTop, (int)size.getX(), (int)size.getY());
//
//	          ImageIO.write(img, ImageType, new File(this.targetFile + this.filename + "_" + pageIndex + "." + ImageType));
//
//	          File _source = new File(this.targetFile + this.filename + "_" + pageIndex + "." + ImageType);
//
//	          ImageUtil.resize(_source, _source, 165, 103);
//
//	          Base64.encodeFileToFile(this.targetFile + this.filename + "_" + pageIndex + "." + ImageType, this.targetFile + this.filename + "_" + pageIndex + ".txt");
//
//	          _source = null;
//	          deleteFile(this.targetFile + this.filename + "_" + pageIndex + "." + ImageType);
//	        }
//	        return true;
//	      } finally {
//	        if (gr != null) gr.dispose(); 
//	      }
//	    }
//	    catch (Exception e)
//	    {
//	      e.printStackTrace();
//	    }
//	    return false;
//	}
//	
//	
//	/**
//	 * PDF파일 이미지 출력
//	 * @param sourceFile 대상 PDF파일 경로 및 파일
//	 * @param resolution 출력 해상도
//	 * @param password 문서 비밀번호
//	 * @return
//	 * @throws IOException 
//	 * 
//	 * 
//	 * PDF에서 이미지만 추출하기 
//	 * 
//	 * PDDocument document = null; 
//	     try {
//	         document = PDDocument.load(sourceFile);
//	     } catch (IOException ex) {
//	         System.out.println("" + ex);
//	     }
//	     List pages = document.getDocumentCatalog().getAllPages();
//	     Iterator iter = pages.iterator(); 
//	     int i =1;
//	     String name = null;
//	 
//	     while (iter.hasNext()) {
//	         PDPage page = (PDPage) iter.next();
//	         PDResources resources = page.getResources();
//	         Map pageImages = resources.getImages();
//
//	         if (pageImages != null) { 
//	             Iterator imageIter = pageImages.keySet().iterator();
//	             while (imageIter.hasNext()) {
//	                 String key = (String) imageIter.next();
//	                 PDXObjectImage image = (PDXObjectImage) pageImages.get(key);
//	                 
//	                 File outputFile = new File(targetFile + i + ".png");
//	                 ImageIO.write( image.getRGBImage(), "png", outputFile);
//	                 
//	                 i++;
//	             }
//	         }
//	     }
//	 * 
//	 * 
//	 */
//	@SuppressWarnings("finally")
//	public synchronized boolean ImageCreatePDF(String Type) throws IOException
//	{
//	    System.out.println("ApachePotImageCreatePDF Called ..");
//
//	    PDDocument document = null;
//	    try {
//	      document = PDDocument.load(new File(this.sourceFile));
//	      PDFRenderer pdfRenderer = new PDFRenderer(document);
//	      int pageCounter = 0;
//	      System.out.println("페이지 : " + document.getNumberOfPages());
//
//	      if ("T".equals(this.fileMode)) {
//	        int length = 5;
//
//	        if (document.getNumberOfPages() < 5) {
//	          length = document.getNumberOfPages();
//	        }
//
//	        for (int i = 0; i < length; i++)
//	        {
//	          BufferedImage bim = pdfRenderer.renderImageWithDPI(i, 200.0F, ImageType.RGB);
//
//	          ImageIOUtil.writeImage(bim, this.targetFile + this.filename + "_" + i + "." + Type, 200);
//
//	          File _source = new File(this.targetFile + this.filename + "_" + i + "." + Type);
//
//	          ImageUtil.resize(_source, _source, 165, 103);
//
//	          Base64.encodeFileToFile(this.targetFile + this.filename + "_" + i + "." + Type, this.targetFile + this.filename + "_" + i + ".txt");
//
//	          _source = null;
//	          deleteFile(this.targetFile + this.filename + "_" + i + "." + Type);
//	        }
//	      }
//	      else
//	      {
//	        for (int i = 0; i < 1; i++)
//	        {
//	          BufferedImage bim = pdfRenderer.renderImageWithDPI(i, 200.0F, ImageType.RGB);
//
//	          ImageIOUtil.writeImage(bim, this.targetFile + this.filename + "_" + i + "." + Type, 200);
//
//	          File _source = new File(this.targetFile + this.filename + "_" + i + "." + Type);
//
//	          ImageUtil.resize(_source, _source, 165, 103);
//
//	          Base64.encodeFileToFile(this.targetFile + this.filename + "_" + i + "." + Type, this.targetFile + this.filename + "_" + i + ".txt");
//
//	          _source = null;
//	          deleteFile(this.targetFile + this.filename + "_" + i + "." + Type);
//	        }
//	      }
//	    }
//	    catch (Exception e)
//	    {
//	      System.err.println(e.getMessage());
//	    }
//	    finally {
//	      if (document == null); 
//	    }document.close();
//
//	    return true;
//	}
//	
//	
//	/**
//	* ##################################################
//	* PPT Image Create
//	* 
//	* 	BufferedImage img = new BufferedImage(pgsize.width, pgsize.height,
//	BufferedImage.TYPE_INT_RGB);
//	Graphics2D graphics = img.createGraphics();
//		
//	// 이미지 영역을 클리어
//	graphics.setPaint(Color.white);
//	graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width,
//	pgsize.height));
//	
// 
//	// 이미지 그리기
//	slide[i].draw(graphics);
// 
//	// 파일로 저장
//	FileOutputStream out = new FileOutputStream(targetFile + filename + "_" + (i + 1) + "." + ImageType);
//	ImageIO.write(img, ImageType, out);
//	out.close();
//	* 
//	* 
//	* ##################################################
//	 * @return 
//    */
//	public synchronized boolean ImageCreatePPT(String ImageType) throws IOException
//	{
//	    System.out.println("ApachePotImageCreatePPT Called ..");
//
//	    FileInputStream is = new FileInputStream(this.sourceFile);
//	    SlideShow ppt = new SlideShow(is);
//
//	    is.close();
//
//	    double zoom = 2.0D;
//	    AffineTransform at = new AffineTransform();
//	    at.setToScale(zoom, zoom);
//
//	    Dimension pgsize = ppt.getPageSize();
//
//	    Slide[] slide = ppt.getSlides();
//
//	    if ("T".equals(this.fileMode)) {
//	      int length = 5;
//
//	      if (slide.length < 5) {
//	        length = slide.length;
//	      }
//
//	      makeFolder(this.targetFile);
//
//	      for (int i = 0; i < length; i++)
//	      {
//	        BufferedImage img = new BufferedImage((int)Math.ceil(pgsize.width * zoom), (int)Math.ceil(pgsize.height * zoom), 1);
//	        Graphics2D graphics = img.createGraphics();
//	        graphics.setTransform(at);
//
//	        graphics.setPaint(Color.white);
//	        graphics.fill(new Rectangle2D.Float(0.0F, 0.0F, (int)Math.ceil(pgsize.width * zoom), (int)Math.ceil(pgsize.height * zoom)));
//	        slide[i].draw(graphics);
//	        FileOutputStream out = new FileOutputStream(this.targetFile + this.filename + "_" + i + "." + ImageType);
//	        ImageIO.write(img, ImageType, out);
//	        Base64.encodeFileToFile(this.targetFile + this.filename + "_" + i + "." + ImageType, this.targetFile + this.filename + "_" + i + ".txt");
//	        out.close();
//	        deleteFile(this.targetFile + this.filename + "_" + i + "." + ImageType);
//	      }
//	    }
//	    else {
//	      int i = 0;
//
//	      int j = 0;
//	      if (slide.length > 2) {
//	        j = 1;
//	      }
//
//	      BufferedImage img = new BufferedImage((int)Math.ceil(pgsize.width * zoom), (int)Math.ceil(pgsize.height * zoom), 1);
//	      Graphics2D graphics = img.createGraphics();
//	      graphics.setTransform(at);
//
//	      graphics.setPaint(Color.white);
//	      graphics.fill(new Rectangle2D.Float(0.0F, 0.0F, (int)Math.ceil(pgsize.width * zoom), (int)Math.ceil(pgsize.height * zoom)));
//	      slide[j].draw(graphics);
//	      FileOutputStream out = new FileOutputStream(this.targetFile + this.filename + "_" + i + "." + ImageType);
//	      ImageIO.write(img, ImageType, out);
//
//	      File _source = new File(this.targetFile + this.filename + "_" + i + "." + ImageType);
//
//	      ImageUtil.resize(_source, _source, 165, 103);
//
//	      Base64.encodeFileToFile(this.targetFile + this.filename + "_" + i + "." + ImageType, this.targetFile + this.filename + "_" + i + ".txt");
//
//	      out.close();
//
//	      _source = null;
//	      deleteFile(this.targetFile + this.filename + "_" + i + "." + ImageType);
//	    }
//
//	    return true;
//	}
//	
//	
//	/**
//	* ##################################################
//	* PPTX Image Create
//	* ##################################################
//	 * @return 
//    */
//	public synchronized boolean ImageCreatePPTX(String ImageType) throws IOException
//	{
//	    FileInputStream is = new FileInputStream(this.sourceFile);
//	    XMLSlideShow ppt = new XMLSlideShow(is);
//	    is.close();
//
//	    double zoom = 2.0D;
//	    AffineTransform at = new AffineTransform();
//	    at.setToScale(zoom, zoom);
//
//	    Dimension pgsize = ppt.getPageSize();
//
//	    XSLFSlide[] slide = ppt.getSlides();
//
//	    if ("T".equals(this.fileMode)) {
//	      int length = 5;
//
//	      if (slide.length < 5) {
//	        length = slide.length;
//	      }
//
//	      makeFolder(this.targetFile);
//
//	      for (int i = 0; i < length; i++)
//	      {
//	        BufferedImage img = new BufferedImage((int)Math.ceil(pgsize.width * zoom), (int)Math.ceil(pgsize.height * zoom), 1);
//
//	        Graphics2D graphics = img.createGraphics();
//	        graphics.setTransform(at);
//
//	        graphics.setPaint(Color.white);
//	        graphics.fill(new Rectangle2D.Float(0.0F, 0.0F, (int)Math.ceil(pgsize.width * zoom), (int)Math.ceil(pgsize.height * zoom)));
//
//	        slide[i].draw(graphics);
//
//	        FileOutputStream out = new FileOutputStream(this.targetFile + this.filename + "_" + i + "." + ImageType);
//	        ImageIO.write(img, ImageType, out);
//	        out.close();
//
//	        File f = new File(this.targetFile + this.filename + "_" + i + "." + ImageType);
//
//	        if (f.exists())
//	        {
//	          Base64.encodeFileToFile(this.targetFile + this.filename + "_" + i + "." + ImageType, 
//	            this.targetFile + this.filename + "_" + i + ".txt");
//
//	          deleteFile(this.targetFile + this.filename + "_" + i + "." + ImageType);
//	        }
//	        else {
//	          System.out.println(f.getName() + " 파일이 존재하지 않습니다.");
//	        }
//
//	        f = null;
//	      }
//
//	    }
//	    else
//	    {
//	      int i = 0;
//
//	      int j = 0;
//	      if (slide.length > 2) {
//	        j = 1;
//	      }
//
//	      System.out.println(i);
//
//	      BufferedImage img = new BufferedImage((int)Math.ceil(pgsize.width * zoom), (int)Math.ceil(pgsize.height * zoom), 1);
//	      Graphics2D graphics = img.createGraphics();
//	      graphics.setTransform(at);
//
//	      graphics.setPaint(Color.white);
//	      graphics.fill(new Rectangle2D.Float(0.0F, 0.0F, (int)Math.ceil(pgsize.width * zoom), (int)Math.ceil(pgsize.height * zoom)));
//	      slide[j].draw(graphics);
//
//	      FileOutputStream out = new FileOutputStream(this.targetFile + this.filename + "_" + i + "." + ImageType);
//	      ImageIO.write(img, ImageType, out);
//
//	      File _source = new File(this.targetFile + this.filename + "_" + i + "." + ImageType);
//
//	      ImageUtil.resize(_source, _source, 165, 103);
//
//	      System.out.println(this.targetFile + this.filename + "_" + i + ".txt");
//
//	      Base64.encodeFileToFile(this.targetFile + this.filename + "_" + i + "." + ImageType, this.targetFile + this.filename + "_" + i + ".txt");
//
//	      out.close();
//	      _source = null;
//
//	      deleteFile(this.targetFile + this.filename + "_" + i + "." + ImageType);
//	    }
//
//	    return true;
//	}
//	
//	public boolean makeFolder(String Path) {
//		
//		File desti = new File(Path);
//		
//		boolean flag = false;
//
//	  //해당 디렉토리의 존재여부를 확인
//
//		if(!desti.exists()){
//
//			//없다면 생성
//			desti.mkdirs(); 
//			
//			flag = true;
//
//		}
//		
//		return flag;
//	}
//	
//	public boolean deleteFile(String filePath) {
//		File file = new File(filePath);
//		if (!file.isFile()) {
//			System.out.println("File not exist =>" + filePath);
//			return false;
//		}
//		
//		return file.delete();
//		//return true;
//	}
// 
//	
//	public static String IntToLetters(int value)
//	{
//		String result = "";
//		while (--value >= 0)
//		{
//		    result = (char)('A' + value % 26 ) + result;
//		    value /= 26;
//		}
//		return result;
//	}
}
