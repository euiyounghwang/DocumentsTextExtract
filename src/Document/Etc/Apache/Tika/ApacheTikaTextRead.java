package Document.Etc.Apache.Tika;

import java.io.ByteArrayOutputStream;  
import java.io.File;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.net.URL;  
   
import org.apache.tika.detect.DefaultDetector;  
import org.apache.tika.detect.Detector;  
import org.apache.tika.io.TikaInputStream;  
import org.apache.tika.metadata.Metadata;  
import org.apache.tika.parser.AutoDetectParser;  
import org.apache.tika.parser.ParseContext;  
import org.apache.tika.parser.Parser;  
import org.apache.tika.sax.BodyContentHandler;  
   
import org.xml.sax.ContentHandler;  
   
public class ApacheTikaTextRead 
{  
	  private OutputStream outputstream;  
	  private ParseContext context;  
	  private Detector detector;  
	  private Parser parser;  
	  private Metadata metadata;  
	  private String extractedText;  
	   
	  public ApacheTikaTextRead() 
	  {  
		   context = new ParseContext();  
		   detector = new DefaultDetector();  
		   parser = new AutoDetectParser(detector);  
		   context.set(Parser.class, parser);  
		   outputstream = new ByteArrayOutputStream();  
		   metadata = new Metadata();  
	  }  
	   
	  /**
		 * This class parses the microsoft word files except .docx,.pptx and 
		 * latest MSword files.
		 * 
		 * # etc file
		 */
	  public String process(String filename) throws Exception 
	  {  
		    URL url;  
		    File file = new File(filename);  
		    if (file.isFile()) {  
		      url = file.toURI().toURL();  
		    } else {  
		      url = new URL(filename);  
		    }  
		    InputStream input = TikaInputStream.get(url, metadata);  
		    ContentHandler handler = new BodyContentHandler(outputstream);  
		    parser.parse(input, handler, metadata, context);  
		    input.close();  
		    
		    return outputstream.toString();
	  }  
}
   