package P1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
String configpath="resources//config.properties";
FileInputStream fis=new FileInputStream(configpath);
Properties prop=new Properties();
prop.load(fis);
System.out.println(prop.getProperty("url"));
	}

}
