package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    // Singleton instance of Properties
    private static final Properties properties = new Properties();

    static {
        // Load properties from config file with resource management
        try (FileInputStream fileInputStream = new FileInputStream(
                System.getProperty("user.dir") + "/src/main/resources/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.err.println("❌ Failed to load configuration properties from config.properties");
            System.err.println("Expected path: " + System.getProperty("user.dir") + "/src/main/resources/config.properties");
            throw new RuntimeException("Failed to load configuration properties", e);
        }
    }

    /**
     * Get property value as String
     * @param key the property key
     * @return the property value
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            System.err.println("⚠️  Property with key '" + key + "' not found in config.properties");
        }
        return value;
    }

    /**
     * Get property value as Integer
     * @param key the property key
     * @return the property value as an integer
     */
    public static int getIntProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            System.err.println("⚠️  Property with key '" + key + "' not found in config.properties");
            throw new IllegalArgumentException("Key not found: " + key);
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.err.println("❌ Failed to parse property value for key '" + key + "' as an integer. Value found: " + value);
            throw new RuntimeException(e);
        }
    }
}
