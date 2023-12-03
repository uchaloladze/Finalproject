package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private static final Properties properties;

    static {
        properties = new Properties();
        String filePath = "src/config.properties"; // Specify the path to your properties file
        try {
            // Load the properties from the file
            properties.load(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        // Retrieve a property value based on the key
        return properties.getProperty(key);
    }
}
