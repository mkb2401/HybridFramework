package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonFunctions {

	public static String getValue(String key) throws IOException
	{
		String configpath="resources//config.properties";
		FileInputStream fis=new FileInputStream(configpath);
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
}
