package settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configProperties {
    private static Properties properties;
    private static String configpath = "Config/configsettings.properties";

    public static String getBaseUrl() {
        loadProperties();
        return properties.getProperty("BaseURL");
    }

    private static void loadProperties() {
        if (properties == null) {
            properties = new Properties();
            try (FileInputStream input = new FileInputStream(configpath)) {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}