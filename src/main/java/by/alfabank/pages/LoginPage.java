package by.alfabank.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;

@NoArgsConstructor
public class LoginPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Вход в Alfa-Test')]")
    private WebElement pageTitle;

    @AndroidFindBy(id = "etUsername")
    private WebElement loginInput;

    @AndroidFindBy(id = "etPassword")
    private WebElement passwordInput;

    @AndroidFindBy(uiAutomator = "text(\"Вход\")")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'неверные данные')]")
    private WebElement loginErrorMessage;

    @Step("Устанавливаем курсор в поле ввода логина")
    public void clickLoginInput() {
        loginInput.click();
    }

    @Step("Ввод логина")
    public LoginPage enterLogin(String login) {
        loginInput.clear();
        loginInput.sendKeys(login);
        return this;
    }

    @Step("Получение атрибутов поля логин")
    public String getLoginAttribute() {
        return loginInput.getAttribute("text");
    }

    @Step("Устанавливаем курсор в поле ввода пароль")
    public void clickPasswordInput() {
        loginInput.click();
    }

    @Step("Ввод пароля")
    public LoginPage enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Получение атрибутов поля логин")
    public String getPasswordAttribute() {
        return passwordInput.getAttribute("text");
    }

    @Step("Тап по кнопке \"Войти\"")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Получение ошибки авторизации")
    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }
}
