import com.codeborne.selenide.WebDriverRunner;
import org.example.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class OKHomeTest extends BaseTest {

    @BeforeAll
    public static void setupLoginData() {
        TestDataRegistry.put("login", "technopol66");
        TestDataRegistry.put("password", "technopolisPassword");
    }

    @BeforeEach
    public void login() throws AuthError {
        String login = TestDataRegistry.get("login");
        String password = TestDataRegistry.get("password");

        OKLoginPage loginPage = (OKLoginPage) PageFactory.createInitialPage(false, "login");
        loginPage
                .enterLogin(login)
                .enterPassword(password)
                .clickLoginButton();
    }

    @ParameterizedTest
    @CsvSource({
            "hobby, /hobby",
            "friends, /friends"
    })
    @DisplayName("Тест перехода к разделам 'Увлечения' и 'Друзья'")
    public void testNavigation(String button, String expectedUrlSuffix) {
        OKHomePage homePage = (OKHomePage) PageFactory.createInitialPage(true, "home");

        homePage.clickButton(button);
        WaitDecorator wait = new WaitDecorator(WebDriverRunner.getWebDriver());
        wait.until(urlContains(expectedUrlSuffix));

        assertTrue(WebDriverRunner.url().endsWith(expectedUrlSuffix), "Ошибочный url");
    }
}
