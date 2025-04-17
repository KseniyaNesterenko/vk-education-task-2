package org.example;

public class PageFactory {

    public static OKLoginPage createLoginPage() {
        return new OKLoginPage();
    }

    public static OKHomePage createHomePage() {
        return new OKHomePage();
    }

    public static OKFeedPage createFeedPage() {
        return new OKFeedPage();
    }

    public static OkFriendsPage createFriendsPage() {
        return new OkFriendsPage();
    }
}