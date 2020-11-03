package utilidades;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    public static Properties loadProperty(String propertiesURL) {
        try {
            Properties properties = new Properties();
            System.out.println(propertiesURL);
            InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesURL);
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            return null;
        }
    }
}
