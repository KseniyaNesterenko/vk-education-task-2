package org.example;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Раздел 'Друзья' на сайте Одноклассников.
 */
public class OkFriendsPage {

    private static final String FRIEND_NAME_FIELD_XPATH = "//*[contains(@placeholder, 'Искать друзей')]";

    private final SelenideElement friendNameField = $x(FRIEND_NAME_FIELD_XPATH);

    public OkFriendsPage searchFriend(String friendName) {
        friendNameField.shouldBe(visible.because("Поле поиска друзей не найдено"))
                .setValue(friendName)
                .pressEnter();
        return this;
    }

    public boolean isFriendFound(String friendName) {
        SelenideElement friendElement = $x("//*[contains(text(), '" + friendName + "')]");
        return friendElement.shouldBe(visible.because("Друг с именем '" + friendName + "' не найден")).isDisplayed();
    }
}