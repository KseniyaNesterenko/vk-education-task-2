package org.example;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;

public abstract class LoadableComponent {

    private boolean loaded = false;

    protected abstract SelenideElement getElementToCheck();

    public void waitUntilLoaded() {
        if (!loaded) {
            getElementToCheck().shouldBe(visible);
            loaded = true;
        }
    }

    public boolean isLoaded() {
        return loaded;
    }
}
