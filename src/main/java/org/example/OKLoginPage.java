package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class OKLoginPage {
    private final SelenideElement userNameField = $x("//*[@id=\"field_email\"]");
    private final SelenideElement passwordField = $x("//*[@id=\"field_password\"]");
    private final SelenideElement loginButton = $x("//input[@value='Войти в Одноклассники']");


    public void enterLogin(String login) {
        userNameField.setValue(login);
    }

    public void enterPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public SelenideElement getUserNameField() {
        return userNameField;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public SelenideElement getLoginButton() {
        return loginButton;
    }
}
