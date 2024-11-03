package by.alfabank.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;

@NoArgsConstructor
public class MainPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Вход в Alfa-Test выполнен']")
    private WebElement successMessage;

    @Step("Отображается сообщение об успешной авторизации")
    public boolean isSuccessMessage() {
        return successMessage.isDisplayed();
    }
}
