package by.alfabank.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static by.alfabank.configuration.DriverManager.getDriver;


public class BasePage {

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }
}
