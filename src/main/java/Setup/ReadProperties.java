package Setup;

import java.io.FileInputStream;
import java.io.InputStream;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	static Properties prop = new Properties();

	InputStream readfile;

	public ReadProperties() {
		try {
			readfile = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\Configuration\\config.properties");
			prop.load(readfile);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUrl() {
		// TODO Auto-generated method stub
		String url = prop.getProperty("url");

		return url;
	}

}
