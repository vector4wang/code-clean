package 注释;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author vector
 * @Data 2018/8/17 0017
 * @Description 喃喃自语
 */
public class Demo441 {
	public void loadProperties() {
		try {
			String propertiesPath = propertiesLocation + "/" + PROPERTIES_FILE;
			FileInputStream propertiesStream = new FileInputStream(propertiesPath);
			loadedProperties.load(propertiesStream);
		} catch (IOException e) {
			// No properties files means all defaults are loaded
		}
	}
}
