import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.function.Function;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class WaitDecorator {
    private final WebDriverWait wait;
    public WaitDecorator(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public <T> T until(Function<WebDriver, T> condition) {
        return wait.until(condition);
    }
}
