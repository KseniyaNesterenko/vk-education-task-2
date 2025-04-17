package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class OKFeedPage {
    public boolean isUserLoggedIn(String username) {
        SelenideElement userProfile = $x("//*[contains(text(), '" + username + "')]");
        return userProfile.shouldBe(visible.because("Профиль пользователя не найден в DOM")).isDisplayed();
    }
}