import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitDecorator {
    private final WebDriverWait wait;

    public WaitDecorator() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public <T> T until(Function<WebDriver, T> condition) {
        return wait.until(condition);
    }
}
