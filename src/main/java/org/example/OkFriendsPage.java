package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.CollectionCondition;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class OkFriendsPage extends BasePage {

    private static final SelenideElement friendNameField =
            $x("//*[contains(@placeholder, 'Искать друзей')]");

    public OkFriendsPage searchFriend(String friendName) {
        new LoadableComponent() {
            @Override
            protected SelenideElement getElementToCheck() {
                return friendNameField;
            }
        }.waitUntilLoaded();

        friendNameField.setValue(friendName).pressEnter();
        return this;
    }

    public boolean isFriendFound(String friendName) {
        ElementsCollection results = $$x("//a[contains(@class, 'gs_result_i_t_name')]");

        results.shouldBe(CollectionCondition.sizeGreaterThan(0)
                .because("Результаты поиска не загрузились"));

        String normalizedName = friendName.replaceAll("\\s+", " ").trim();
        return results.stream().anyMatch(result ->
                result.getText().replaceAll("\\s+", " ").trim().equalsIgnoreCase(normalizedName)
        );
    }
}
