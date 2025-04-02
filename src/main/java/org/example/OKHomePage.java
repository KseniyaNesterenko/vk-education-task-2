package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Домашняя страница.
 */
public class OKHomePage {

    private static final String HOBBY_BUTTON_XPATH = "//*[@class='tico null' and @role='button' and contains(text(), 'Увлечения')]";
    private static final String FRIENDS_BUTTON_XPATH = "//*[@class='tico null' and @role='button' and contains(text(), 'Друзья')]";

    /**
     * Кнопки для перехода в разделы 'Увлечения' и 'Друзья'.
     */
    private final SelenideElement hobbyButton = $x(HOBBY_BUTTON_XPATH);
    private final SelenideElement friendsButton = $x(FRIENDS_BUTTON_XPATH);

    public void clickHobbyButton() {
        hobbyButton.shouldBe(visible.because("Кнопка 'Увлечения' не найдена")).click();
    }

    public void clickFriendsButton() {
        friendsButton.shouldBe(visible.because("Кнопка 'Друзья' не найдена")).click();
    }
}
