import java.io.FileNotFoundException;

import java.io.IOException;
//import org.apache.poi.xwpf.converter.core.XWPFConverterException;
import Documents.Office.Poi.ApachePoiTextRead;

public class ECMTextMinigExtract {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		// TODO Auto-generated method stub

		try {
			try {
				System.out.println(new ApachePoiTextRead("/ES/tmp_ECM_0900bf4ba1624820_0900bf4ba1624820_1634712568326.pdf").CommonTextMain());
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
