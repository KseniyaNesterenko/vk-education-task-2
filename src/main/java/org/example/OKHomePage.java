package org.example;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

import java.util.Map;

public class OKHomePage extends BasePage {

    private static final String HOBBY_BUTTON = "//*[normalize-space(text())='Увлечения']";
    private static final String FRIENDS_BUTTON = "//*[normalize-space(text())='Друзья']";

    private static final Map<String, SelenideElement> buttons = Map.of(
            "hobby", $x(HOBBY_BUTTON),
            "friends", $x(FRIENDS_BUTTON)
    );

    public OKHomePage clickButton(String buttonName) {
        SelenideElement button = buttons.get(buttonName);
        if (button != null) {
            button.click();
        } else {
            throw new IllegalArgumentException("Неизвестная кнопка: " + buttonName);
        }
        return this;
    }

    @Override
    protected void checkPage() {
        shouldBeVisible(buttons.get("hobby"), buttons.get("friends"));
    }
}
