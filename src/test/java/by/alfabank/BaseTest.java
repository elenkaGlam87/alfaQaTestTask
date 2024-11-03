package by.alfabank;

import by.alfabank.pages.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

import static by.alfabank.configuration.DriverManager.getDriver;
import static by.alfabank.configuration.DriverManager.loadApplication;
import static by.alfabank.configuration.DriverManager.stopDriver;
import static by.alfabank.configuration.DriverManager.terminateApplication;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected final LoginPage loginPage = new LoginPage();

    @BeforeAll
    void setupDriver() {
       getDriver();
    }

    @BeforeEach
    void activateApp() {
        loadApplication();
    }

    @AfterEach
    void closeApp() {
        if (getDriver() != null) {
            terminateApplication();
        }
    }

    @AfterAll
    void terminateDriver() {
        stopDriver();
    }
}
