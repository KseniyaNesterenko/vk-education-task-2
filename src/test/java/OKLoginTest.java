import org.example.AuthError;
import org.example.OKFeedPage;
import org.example.OKLoginPage;
import org.example.PageFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OKLoginTest extends BaseTest {

    @Test
    @Timeout(value = 5)
    @DisplayName("Проверка видимости всех элементов на странице логина")
    public void testPageElementsAreVisible() {
        OKLoginPage loginPage = PageFactory.createLoginPage();

        assertAll("Проверка видимости элементов на странице",
                () -> assertTrue(loginPage.isUserNameFieldVisible(), "Поле ввода логина отсутствует"),
                () -> assertTrue(loginPage.isPasswordFieldVisible(), "Поле ввода пароля отсутствует"),
                () -> assertTrue(loginPage.isLoginButtonVisible(), "Кнопка входа отсутствует")
        );
    }

    @ParameterizedTest
    @MethodSource("LoginDataProvider#loginData")
    @DisplayName("Тестирование логина с некорректными данными")
    @Tag("login")
    public void testLoginWithDifferentInvalidScenarios(String login, String password, String expectedErrorMessage) throws AuthError {
        OKLoginPage loginPage = PageFactory.createLoginPage();

        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        if (expectedErrorMessage != null) {
            assertTrue(loginPage.isErrorMessageDisplayed(expectedErrorMessage), "Ошибка не отобразилась или неверный текст");
        }
    }

    @Test
    @DisplayName("Тестирование успешного входа с корректными данными")
    @Tag("login")
    public void testLoginWithValidCredentials() throws AuthError {
        OKLoginPage loginPage = PageFactory.createLoginPage();
        loginPage.enterLogin("technopol66");
        loginPage.enterPassword("technopolisPassword");
        loginPage.clickLoginButton();

        OKFeedPage feedPage = PageFactory.createFeedPage();
        assertTrue(feedPage.isUserLoggedIn("technopol66"), "Пользователь не был перенаправлен на страницу профиля");
    }
}
