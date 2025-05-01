import org.example.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class OKFriendsTest extends BaseTest {

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

    @TestFactory
    @DisplayName("Тест поиска друзей")
    public List<DynamicTest> testSearchFriend() {
        OKHomePage homePage = (OKHomePage) PageFactory.createInitialPage(true, "home");
        homePage.clickButton("friends");

        OkFriendsPage friendsPage = (OkFriendsPage) PageFactory.createInitialPage(true, "friends");
        String[] friendNames = {"Дмитрий Иванов", "Алексей Иванов", "Мария Иванова"};

        return Arrays.stream(friendNames)
                .map(friendName -> DynamicTest.dynamicTest(
                        "Поиск друга: " + friendName,
                        () -> {
                            friendsPage.searchFriend(friendName);
                            assertTrue(friendsPage.isFriendFound(friendName), "Друг " + friendName + " не найден.");
                        }
                )).toList();
    }
}