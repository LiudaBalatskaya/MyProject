package helper;

import jdk.internal.org.xml.sax.Locator;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by LiudaBalatskaya on 11/17/2016.
 */
public class Creds {
    private static final Properties creds;

    static {
        creds = new Properties();
        InputStream is = Locator.class.getResourceAsStream("/creds.properties");
        try {
            creds.load(is);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String[] get(String locatorName) {
        return creds.getProperty(locatorName).split(",");
    }
}
