package org.example;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class OKFeedPage extends BasePage {
    public boolean isUserLoggedIn(String username) {
        SelenideElement userProfile = $x("//*/a/div[contains(text(), '" + username + "')]");
        return userProfile.isDisplayed();
    }

    @Override
    protected void checkPage() {
        $x("//*/a/div[contains(text(), 'technopol66')]").shouldBe(visible, Duration.ofSeconds(10));
    }
}