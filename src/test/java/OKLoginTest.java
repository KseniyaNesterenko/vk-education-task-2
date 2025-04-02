import org.example.OKFeedPage;
import org.example.OKLoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OKLoginTest extends BaseTest {

    @Test
    @Timeout(value = 5)
    @DisplayName("Проверка видимости всех элементов на странице логина")
    public void testPageElementsAreVisible() {
        OKLoginPage loginPage = new OKLoginPage();

        assertAll("Проверка видимости элементов на странице",
                () -> assertTrue(loginPage.isUserNameFieldVisible(), "Поле ввода логина отсутствует"),
                () -> assertTrue(loginPage.isPasswordFieldVisible(), "Поле ввода пароля отсутствует"),
                () -> assertTrue(loginPage.isLoginButtonVisible(), "Кнопка входа отсутствует")
        );
    }

    @ParameterizedTest
    @CsvSource({
            "'', 'any_password', 'Введите логин'",
            "'any_login', '', 'Введите пароль'",
            "'invalid_login', 'invalid_password', 'Неправильно указан логин и/или пароль'"
    })
    @DisplayName("Тестирование логина с некорректными данными")
    @Tag("login")
    public void testLoginWithDifferentInvalidScenarios(String login, String password, String expectedErrorMessage) {
        OKLoginPage loginPage = new OKLoginPage();

        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isErrorMessageDisplayed(expectedErrorMessage), "Ошибка не отобразилась или неверный текст");
    }

    @Test
    @DisplayName("Тестирование успешного входа с корректными данными")
    @Tag("login")
    public void testLoginWithValidCredentials() {
        OKLoginPage loginPage = new OKLoginPage();
        loginPage.enterLogin("technopol66");
        loginPage.enterPassword("technopolisPassword");
        loginPage.clickLoginButton();

        OKFeedPage feedPage = new OKFeedPage();
        assertTrue(feedPage.isUserLoggedIn(), "Пользователь не был перенаправлен на страницу профиля");
    }
}
