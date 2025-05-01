package org.example;

public class PageFactory {

    public static BasePage createInitialPage(boolean isLoggedIn, String destination) {
        if (!isLoggedIn) {
            return new OKLoginPage();
        }

        return switch (destination.toLowerCase()) {
            case "home" -> new OKHomePage();
            case "feed" -> new OKFeedPage();
            case "friends" -> new OkFriendsPage();
            default -> throw new IllegalArgumentException("Unknown page type: " + destination);
        };
    }
}
