package by.alfabank.configuration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

import static by.alfabank.configuration.ConfigurationConstants.APP_PACKAGE;
import static by.alfabank.configuration.ConfigurationConstants.PLATFORM_NAME;
import static by.alfabank.configuration.DeviceManager.getAppiumServerUrl;
import static by.alfabank.configuration.DeviceManager.getCapabilities;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static io.appium.java_client.remote.MobilePlatform.IOS;

@Slf4j
public class DriverManager {

    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        if (driver == null) {
            return createDriver();
        } else {
            return driver;
        }
    }

    public static void stopDriver() {
        driver.quit();
        driver = null;
        log.info("Driver closed");
    }

    public static void terminateApplication() {
        ((AndroidDriver) driver).terminateApp(APP_PACKAGE);
        log.info("Application terminated");
    }

    public static void loadApplication() {
            ((AndroidDriver) driver).activateApp(APP_PACKAGE);
            log.info("Application loaded");
    }

    private static AppiumDriver createDriver() {
        switch (PLATFORM_NAME) {
            case ANDROID -> driver = new AndroidDriver(getAppiumServerUrl(), getCapabilities("UiAutomator2"));
            case IOS -> driver = new IOSDriver(getAppiumServerUrl(), getCapabilities("XCUITest"));
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        log.info("Driver created for platform {}", PLATFORM_NAME);
        return driver;
    }
}
