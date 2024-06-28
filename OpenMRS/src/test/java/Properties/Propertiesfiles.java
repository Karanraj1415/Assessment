package Properties;

import java.io.FileInputStream;
import java.util.Properties;

public class Propertiesfiles {
	
	public String read(String value) throws Exception {

		FileInputStream f = new FileInputStream(
				"C:\\Users\\donka\\OneDrive\\Documents\\New\\OpenMRS\\src\\Config\\Config.properties");
		Properties propety = new Properties();
		
		propety.load(f);
		String data = propety.getProperty(value);
		return data;
		

	}

}
