package by.alfabank.configuration;

import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static by.alfabank.configuration.ConfigurationConstants.APP;
import static by.alfabank.configuration.ConfigurationConstants.APP_PACKAGE;
import static by.alfabank.configuration.ConfigurationConstants.DEVICE_NAME;
import static by.alfabank.configuration.ConfigurationConstants.HOST;
import static by.alfabank.configuration.ConfigurationConstants.PLATFORM_NAME;
import static by.alfabank.configuration.ConfigurationConstants.PLATFORM_VERSION;
import static by.alfabank.configuration.ConfigurationConstants.PORT;
import static by.alfabank.configuration.ConfigurationConstants.UDID;

public class DeviceManager {

    public static DesiredCapabilities getCapabilities(String automationName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", DEVICE_NAME);
        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("appium:platformVersion", PLATFORM_VERSION);
        capabilities.setCapability("appium:udid", UDID);
        capabilities.setCapability("appium:appPackage", APP_PACKAGE);
        capabilities.setCapability("appium:app", APP);
        capabilities.setCapability("appium:automationName", automationName);
        return capabilities;
    }

    @SneakyThrows
    public static URL getAppiumServerUrl() {
        return new URL(String.format("http://%s:%s/wd/hub", HOST, PORT));
    }
}
