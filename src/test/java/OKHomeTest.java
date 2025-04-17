import com.codeborne.selenide.WebDriverRunner;
import org.example.OKHomePage;
import org.example.OKLoginPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OKHomeTest extends BaseTest {

    private final String login = "technopol66";
    private final String password = "technopolisPassword";

    @BeforeEach
    public void login() {
        OKLoginPage loginPage = new OKLoginPage();
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @ParameterizedTest
    @CsvSource({
            "hobby, /hobby",
            "friends, /friends"
    })
    @DisplayName("Тест перехода к разделам 'Увлечения' и 'Друзья'")
    public void testNavigation(String button, String expectedUrlSuffix) {
        OKHomePage homePage = new OKHomePage();

        if (button.equals("hobby")) {
            homePage.clickHobbyButton();
        } else if (button.equals("friends")) {
            homePage.clickFriendsButton();
        }

        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(expectedUrlSuffix));

        assertTrue(WebDriverRunner.url().endsWith(expectedUrlSuffix),
                "Ошибочный url");
    }
}
