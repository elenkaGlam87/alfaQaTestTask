package by.alfabank.authorization;

import by.alfabank.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static by.alfabank.constants.ApplicationConstants.FIFTY_ONE_SYMBOLS;
import static by.alfabank.constants.ApplicationConstants.INVALID_LOGIN_SYMBOLS;
import static by.alfabank.constants.ErrorMessages.LOGIN_ERROR;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Owner("Гусакова Елена Олеговна")
@Story("Авторизация")
public class LoginInputTest extends BaseTest {

    @Test
    @DisplayName("Проверка недопустимости использования неразрешенных символов")
    /*
    В данном функционале скорее всего баг, так как фронт должен самостоятельно валидировать поле для ввода логина
    и вывешивать под ним текст ошибки, не дожидаясь тапа по кнопке "Войти".
    Сейчас приходит ошибка, как при попытке авторизации неверным логином или паролем.
     */
    void incorrectSymbolsInLoginTest() {
        String pattern = "^[A-Za-z\\.,/'_\\-\\s]+$";
        loginPage.clickLoginInput();
        loginPage.enterLogin(INVALID_LOGIN_SYMBOLS);
        loginPage.clickLoginButton();

        assertAll(
                () -> assertEquals(LOGIN_ERROR, loginPage.getLoginErrorMessage(), "Отображается неверная ошибка"),
                () -> assertFalse(INVALID_LOGIN_SYMBOLS.matches(pattern), "Введен корректный пароль")
        );
    }

    @Test
    @DisplayName("Проверка недопустимости использования логина, длиннее чем в 50 символов")
    /*
    В данном функционале скорее всего баг, так как обрезка до 50 символов не производится. Также, валидация слишком
    длинного логина (более 50 символов) должна осуществляться на этапе регистрации пользователя, а не авторизации.
     */
    void loginMaxLengthTest() {
        loginPage.clickLoginInput();
        loginPage.enterLogin(FIFTY_ONE_SYMBOLS);
        loginPage.clickLoginButton();

        assertEquals(50, loginPage.getLoginAttribute().length(), "Логин не обрезан до 50 символов");
    }
}


