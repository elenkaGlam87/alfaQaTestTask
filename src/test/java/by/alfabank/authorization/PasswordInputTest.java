package by.alfabank.authorization;

import by.alfabank.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static by.alfabank.constants.ApplicationConstants.FIFTY_ONE_SYMBOLS;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Owner("Гусакова Елена Олеговна")
@Story("Авторизация")
public class PasswordInputTest extends BaseTest {

    @Test
    @DisplayName("Проверка недопустимости использования логина, длиннее чем в 50 символов")
     /*
    В данном функционале скорее всего баг, так как обрезка до 50 символов не производится. Также, валидация слишком
    длинного пароля (более 50 символов) должна осуществляться на этапе регистрации пользователя, а не авторизации.
     */
    void loginMaxLengthTest() {
        loginPage.clickPasswordInput();
        loginPage.enterPassword(FIFTY_ONE_SYMBOLS);
        loginPage.clickLoginButton();

        assertEquals(50, loginPage.getPasswordAttribute().length(), "Пароль не обрезан до 50 символов");
    }
}
