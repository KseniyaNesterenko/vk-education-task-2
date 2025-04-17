import org.example.*;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OKFriendsTest extends BaseTest {

    private final String login = "technopol66";
    private final String password = "technopolisPassword";

    @BeforeEach
    public void login() {
        OKLoginPage loginPage = PageFactory.createLoginPage();

        try {
            loginPage.enterLogin(login);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();
        } catch (AuthError e) {
            assertEquals("Неверный логин или пароль", e.getMessage(), "Сообщение об ошибке не совпадает");
            fail("Ошибка авторизации: " + e.getMessage());
        }
    }


    @TestFactory
    @DisplayName("Тест поиска друзей")
    public List<DynamicTest> testSearchFriend() {
        OKHomePage homePage = PageFactory.createHomePage();
        homePage.clickFriendsButton();

        OkFriendsPage friendsPage = PageFactory.createFriendsPage();
        String[] friendNames = {"Дмитрий", "Алексей", "Мария"};

        return Arrays.asList(friendNames).stream()
                .map(friendName -> DynamicTest.dynamicTest(
                        "Поиск друга: " + friendName,
                        () -> {
                            friendsPage.searchFriend(friendName);
                            assertTrue(friendsPage.isFriendFound(friendName), "Друг " + friendName + " не найден.");
                        }
                ))
                .toList();
    }
}
