package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

public abstract class BasePage {

    protected abstract void checkPage();

    public BasePage() {
        checkPage();
    }

    protected void shouldBeVisible(SelenideElement... elements) {
        for (SelenideElement element : elements) {
            element.shouldBe(visible);
        }
    }
}
