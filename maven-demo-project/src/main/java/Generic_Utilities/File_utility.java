package Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_utility {
 
	public String getPropertiesData(String key) throws Throwable {
		//1. fis object
		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger data/CommonData.properties");
		//2.property object
		Properties p = new Properties();
		p.load(fis);
		//3. call read()
		String value = p.getProperty(key);
		return value;
	}
}
