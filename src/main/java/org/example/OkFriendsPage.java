package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.CollectionCondition;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.Condition;

public class OkFriendsPage extends BasePage {
    public static final String[] FRIEND_NAMES = {"Дмитрий Иванов", "Алексей Иванов", "Мария Иванова"};

    private static final SelenideElement FRIEND_NAME_FIELD =
            $x("//*[contains(@placeholder, 'Искать друзей')]");

    public OkFriendsPage searchFriend(String friendName) {
        FRIEND_NAME_FIELD.setValue(friendName).pressEnter();
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

    @Override
    protected void checkPage() {
        FRIEND_NAME_FIELD.shouldBe(Condition.visible);
    }
}
