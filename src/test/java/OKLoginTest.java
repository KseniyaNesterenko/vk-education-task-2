import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.example.OKLoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class OKLoginTest {

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        open("https://ok.ru");
    }

    @Test
    public void testPageElementsAreVisible() {
        OKLoginPage loginPage = new OKLoginPage();

        loginPage.getUserNameField().shouldBe(visible);
        loginPage.getPasswordField().shouldBe(visible);
        loginPage.getLoginButton().shouldBe(visible);
    }

    @ParameterizedTest
    @CsvSource({
            "'', 'any_password', 'Введите логин'",
            "'any_login', '', 'Введите пароль'",
            "'invalid_login', 'invalid_password', 'Неправильно указан логин и/или пароль'"
    })
    public void testLoginWithDifferentInvalidScenarios(String login, String password, String expectedErrorMessage) {
        OKLoginPage loginPage = new OKLoginPage();

        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        Selenide.$x("//div[contains(@class, 'login_error') and contains(text(), '" + expectedErrorMessage + "')]")
                .shouldBe(visible, Duration.ofSeconds(10));
    }


    // Здесь я при тестировании указала свои реальные данные для входа в мой аккаунт
    @Test
    public void testLoginWithValidCredentials() {
        OKLoginPage loginPage = new OKLoginPage();
        loginPage.enterLogin("valid_name");
        loginPage.enterPassword("valid_password");
        loginPage.clickLoginButton();

        Selenide.$x("//*[@id='hook_Block_Navigation']/div/div/div[1]/a/div[contains(text(), 'Ксения Нестеренко')]")
                .shouldBe(visible, Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}