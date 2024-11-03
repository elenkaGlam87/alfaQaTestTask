package by.alfabank.authorization;

import by.alfabank.BaseTest;
import by.alfabank.pages.MainPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static by.alfabank.constants.ApplicationConstants.EMPTY_CONSTANT;
import static by.alfabank.constants.ApplicationConstants.INVALID_LOGIN;
import static by.alfabank.constants.ApplicationConstants.INVALID_PASSWORD;
import static by.alfabank.constants.ApplicationConstants.VALID_LOGIN;
import static by.alfabank.constants.ApplicationConstants.VALID_PASSWORD;
import static by.alfabank.constants.ErrorMessages.AUTHORIZATION_ERROR;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Owner("Гусакова Елена Олеговна")
@Story("Авторизация")
public class AuthorizationTest extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Тест успешной авторизации в приложении")
    void successAuthorizationTest() {
        loginPage.clickLoginInput();
        loginPage.enterLogin(VALID_LOGIN);
        loginPage.clickPasswordInput();
        loginPage.enterPassword(VALID_PASSWORD);
        loginPage.clickLoginButton();
        mainPage.isSuccessMessage();
    }

    @ParameterizedTest(name = "Попытка авторизации: {2}")
    @MethodSource("wrongParametersForAuthorization")
    @DisplayName("Тест авторизации при невалидных данных")
    void negativeAuthorizationTest(String login, String password, String description) {
        loginPage.clickLoginInput();
        loginPage.enterLogin(login);
        loginPage.clickPasswordInput();
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        assertEquals(AUTHORIZATION_ERROR, loginPage.getLoginErrorMessage(), "Пришел неверный текст ошибки");
    }

    private Stream<Arguments> wrongParametersForAuthorization() {
        return Stream.of(
                Arguments.of(INVALID_LOGIN, INVALID_PASSWORD, "невалидные логин и пароль"),
                Arguments.of(INVALID_LOGIN, VALID_PASSWORD, "невалидный логин и валидный пароль"),
                Arguments.of(VALID_LOGIN, INVALID_PASSWORD, "валидный логин и невалидный пароль"),
                Arguments.of(EMPTY_CONSTANT, EMPTY_CONSTANT, "пустые поля логин и пароль"),
                Arguments.of(VALID_LOGIN, EMPTY_CONSTANT, "валидный логин и пустое поле пароль"),
                Arguments.of(INVALID_LOGIN, EMPTY_CONSTANT, "невалидный логин и пустое поле пароль"),
                Arguments.of(EMPTY_CONSTANT, VALID_PASSWORD, "пустое поле логин и валидный пароль"),
                Arguments.of(EMPTY_CONSTANT, INVALID_PASSWORD, "пустое поле логин и невалидный пароль"));
    }
}
