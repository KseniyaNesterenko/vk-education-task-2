import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.example.TestDataRegistry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeAll
    public static void setupLoginData() {
        TestDataRegistry.put("login", "technopol66");
        TestDataRegistry.put("password", "technopolisPassword");
    }

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        open("https://ok.ru");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
