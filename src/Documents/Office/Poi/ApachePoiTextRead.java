package Documents.Office.Poi;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.apache.log4j.Logger;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;


public class ApachePoiTextRead {

	private String sourceFile;
	private String textFilePath;
	private String textFileName;
	private String targetFile;
	private String filename;
	private String sourcefileExtension;
	private String result;
	// private StringBuffer buffers = new StringBuffer();
	// private StringBuilder buffer = new StringBuilder();
	private StringBuffer buffers  = new StringBuffer();

	public static int successCount = 0;
	public static int failCount = 0;

	public static int totalSuccessCount = 0;
	public static int totalFailCount = 0;
	
	
	/**
	 * MAX File Size Max Rows Max Cols I
	 */
	private int limtedSize = 31457280;
	private int MaxRows = 100, MaxCols = 10;

//	static Logger logger = Logger.getLogger(ApachePoiTextRead.class);
	private File file = null;
	
//	printLog log = new printLog();

	/**
	 * xml totalSize 초기화
	 */
	public void resetFileSize() {
		successCount = 0;
		failCount = 0;
	}
	
	public void totalFileSize() {
		totalSuccessCount += successCount;
		totalFailCount += failCount;
	}
	
	public ApachePoiTextRead(String sourceFile) {
		this.sourceFile = sourceFile;
		file = new File(sourceFile);
		buffers.setLength(0);
	}
	
	public ApachePoiTextRead(String sourceFile, String textFilePath , String textFileName) {
		// TODO Auto-generated constructor stub
		this.sourceFile = sourceFile;
		this.textFilePath = textFilePath;
		this.textFileName = textFileName;
		file = new File(sourceFile);
		buffers.setLength(0);
	}

	public String CommonTextMain() throws Exception {

//		logger.info("INSIDE ~ Text Extract Library");
		
		try
		{
		
			AutoDetectParser parser = new AutoDetectParser();
		    BodyContentHandler handler = new BodyContentHandler(-1);
		    ParseContext context = new ParseContext();
		    Metadata metadata = new Metadata();
		    
	        try (InputStream stream = TikaInputStream.get(Paths.get(sourceFile))) {
		        parser.parse(stream, handler, metadata , context);
		        
				successCount++;
		        return TruncatedTextExtract(handler.toString());
		    }
		    
		}catch (Exception e) {
			failCount++;
			e.printStackTrace();
			// TODO: handle exception
		}
		finally {
			buffers.setLength(0);
			buffers = null;
			System.gc();
		}
		
		return null;
		
	}
	
	public String CommonTextUnfairMain() throws Exception {

//		logger.info("INSIDE ~ Text Extract Library");
		
		try
		{
		
			AutoDetectParser parser = new AutoDetectParser();
		    BodyContentHandler handler = new BodyContentHandler(-1);
		    ParseContext context = new ParseContext();
		    Metadata metadata = new Metadata();
		    
	        try (InputStream stream = TikaInputStream.get(Paths.get(sourceFile))) {
		        parser.parse(stream, handler, metadata , context);
		        
				successCount++;
		        return TruncatedTextUnfairExtract(handler.toString());
		    }
		    
		}catch (Exception e) {
			failCount++;
			e.printStackTrace();
			// TODO: handle exception
		}
		finally {
			buffers.setLength(0);
			buffers = null;
			System.gc();
		}
		
		return null;
		
	}
	
	/**
	 * Truncated Text Extract
	 */
	private String TruncatedTextUnfairExtract(String buf) {
		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
		
		String buftxt = buf.toString();
		
		Pattern tag1 = Pattern.compile("(\\.)(\\.)*");
		Matcher mat1 = tag1.matcher(buftxt);
		buftxt = mat1.replaceAll("\\.");
		
		Pattern tag = Pattern.compile("(\\.)((\\s)?(\\.)?)?((\\.)?(\\s)?)?(\\.)");
		Matcher mat = tag.matcher(buftxt);
		buftxt = mat.replaceAll("\\.");
		
		return buftxt.replaceAll("\\p{Space}", " ")
				.replaceAll("\\[", "")
				.replaceAll("\\^", "").replaceAll("\\@", "")
				.replaceAll("\\'", "")
				.replaceAll("\'", "").replaceAll("\\\"", "")
				.replaceAll("\"", "").replaceAll("null", "")
				.replaceAll(match, "\\|");
	}
	
	/**
	 * Truncated Text Extract
	 */
	private String TruncatedTextExtract(String buf) {

		String match = "[^\\uAC00-\\uD7A3xfe0-9a-zA-Z\\s\\.\\r\\n|\\r|\\n|\\n\\r|^\\u2460-\\u2473|^\\u3250-\\u325F|^\\u32B1-\\u32BF|^\\]|^\\[|^\\)|^\\(|^\\,|^\\.]";

		//		약관공정화용
		return buf.toString().replaceAll("(\\r\\n|\\r|\\n|\\n\\r)", "[ENTER]").replaceAll(match, "").replaceAll("\\p{Space}", " ")
				.replaceAll("\\^", "").replaceAll("\\@", "")
				.replaceAll("\\'", "").replaceAll("\'", "").replaceAll("\\\"", "")
				.replaceAll("\"", "").replaceAll("null", "")
				.replaceAll("\\s+", " ");
		
		
	}
	
	
}
