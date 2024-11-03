package by.alfabank.configuration;

import lombok.SneakyThrows;

public class PropertiesProvider {

    @SneakyThrows
    public static String getProperty(String propertyName) {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("configuration.properties"));
        return System.getProperty(propertyName);
    }
}
