import org.example.OKHomePage;
import org.example.OKLoginPage;
import org.example.OkFriendsPage;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OKFriendsTest extends BaseTest {

    private final String login = "technopol66";
    private final String password = "technopolisPassword";

    @BeforeEach
    public void login() {
        OKLoginPage loginPage = new OKLoginPage();
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @TestFactory
    @DisplayName("Тест поиска друзей")
    public List<DynamicTest> testSearchFriend() {
        OKHomePage homePage = new OKHomePage();
        homePage.clickFriendsButton();

        OkFriendsPage friendsPage = new OkFriendsPage();
        String[] friendNames = {"Дмитрий", "Алексей", "Мария"};

        return Arrays.asList(friendNames).stream()
                .map(friendName -> DynamicTest.dynamicTest(
                        "Поиск друга: " + friendName,
                        () -> {
                            friendsPage.searchFriend(friendName);
                            assertTrue(friendsPage.isFriendFound(), "Друг " + friendName + " не найден.");
                        }
                ))
                .toList();
    }
}
