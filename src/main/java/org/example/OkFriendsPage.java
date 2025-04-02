package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Раздел 'Друзья' на сайте Одноклассников.
 */
public class OkFriendsPage {

    private static final String FRIEND_NAME_FIELD_XPATH = "//*[contains(@placeholder, 'Искать друзей')]";
    private static final String NO_RESULTS_XPATH = "//*[contains(@class, 'stub-empty_t')]";

    private final SelenideElement friendNameField = $x(FRIEND_NAME_FIELD_XPATH);

    /**
     * Ищет друга по имени.
     */
    public void searchFriend(String friendName) {
        friendNameField.shouldBe(visible.because("Поле поиска друзей не найдено")).setValue(friendName).pressEnter();
    }

    /**
     * Проверяет, найден ли друг.
     */
    public boolean isFriendFound() {
        return $x("//*[contains(text(), 'Дмитрий')]").shouldBe(visible.because("Друг не найден")).exists();
    }
}
