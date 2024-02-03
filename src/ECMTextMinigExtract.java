import java.io.FileNotFoundException;

import java.io.IOException;
//import org.apache.poi.xwpf.converter.core.XWPFConverterException;
import Documents.Office.Poi.ApachePoiTextRead;

public class ECMTextMinigExtract {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		// TODO Auto-generated method stub

		try {
			try {
				System.out.println(new ApachePoiTextRead("/Users/euiyoung.hwang/DOC/clustering.pdf").CommonTextMain());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
