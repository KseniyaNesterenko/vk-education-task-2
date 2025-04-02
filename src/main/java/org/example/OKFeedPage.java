package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class OKFeedPage {

    private static final String USER_PROFILE_XPATH = "//*[contains(text(), 'technopol66')]";

    private final SelenideElement userProfile = $x(USER_PROFILE_XPATH);

    public boolean isUserLoggedIn() {
        return userProfile.should(exist.because("Профиль пользователя отсутствует в DOM")).exists();
    }

}
