package org.example;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class OKLoginPage extends BasePage {
    private static final SelenideElement userNameField = $x("//*[@id='field_email']");
    private static final SelenideElement passwordField = $x("//*[@id='field_password']");
    private static final SelenideElement loginButton = $x("//*[@" +
            "value='Войти в Одноклассники']");

    protected static final String ERROR_MESSAGE =
            "//*[(contains(@class, 'login_error') and contains(text(), '%s'))]";

    public OKLoginPage enterLogin(String login) {
        userNameField.setValue(login);
        return this;
    }

    public OKLoginPage enterPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isErrorMessageDisplayed(String expectedMessage) {
        return $x(String.format(ERROR_MESSAGE, expectedMessage)).is(visible);
    }

    public boolean isUserNameFieldVisible() {
        return userNameField.is(visible);
    }

    public boolean isPasswordFieldVisible() {
        return passwordField.is(visible);
    }

    public boolean isLoginButtonVisible() {
        return loginButton.is(visible);
    }

    @Override
    protected void checkPage() {
        shouldBeVisible(userNameField, passwordField, loginButton);
    }
}
