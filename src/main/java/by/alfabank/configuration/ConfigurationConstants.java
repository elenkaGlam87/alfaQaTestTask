package by.alfabank.configuration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConfigurationConstants {

    public static final String PLATFORM_NAME = System.getenv("platformName");
    public static final String DEVICE_NAME = System.getenv("deviceName");
    public static final String PLATFORM_VERSION = System.getenv("osVersion");
    public static final String UDID = System.getenv("udid");
    public static final String APP_PACKAGE = PropertiesProvider.getProperty("appPackage");
    public static final String APP = PropertiesProvider.getProperty("app");
    public static final String HOST = PropertiesProvider.getProperty("host");
    public static final String PORT = PropertiesProvider.getProperty("port");
}
