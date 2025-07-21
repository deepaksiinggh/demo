package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigrationReader {

	
	public static String readDataFromConfigFile(String key) throws IOException {
		Properties prop = new Properties();
		File fs = new File("./src/test/resources/config.properties");
		if(!fs.exists()) {
			return "";
		}
		FileInputStream fis= new FileInputStream(fs);
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
		
	}
	
}
