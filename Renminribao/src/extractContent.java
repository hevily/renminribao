import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import de.l3s.boilerpipe.BoilerpipeProcessingException;


public class extractContent {
public static void main(String[] args){ 
	try {
		FilesArranger.extracContent("C:\\Users\\penghai\\Desktop\\1\\2007");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (BoilerpipeProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}