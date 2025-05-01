package org.example;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class OKFeedPage extends BasePage {
    public boolean isUserLoggedIn(String username) {
        SelenideElement userProfile = $x("//*[contains(text(), '" + username + "')]");
        return userProfile.exists();
    }
}