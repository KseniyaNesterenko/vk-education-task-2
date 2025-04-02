package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница авторизации на сайте Одноклассников.
 */
public class OKLoginPage {

    private static final String USERNAME_FIELD_XPATH = "//*[@id='field_email']";
    private static final String PASSWORD_FIELD_XPATH = "//*[@id='field_password']";
    private static final String LOGIN_BUTTON_XPATH = "//input[@value='Войти в Одноклассники']";
    private static final String ERROR_MESSAGE_XPATH = "//div[contains(@class, 'login_error') and contains(text(), '%s')]";

    private final SelenideElement userNameField = $x(USERNAME_FIELD_XPATH);
    private final SelenideElement passwordField = $x(PASSWORD_FIELD_XPATH);
    private final SelenideElement loginButton = $x(LOGIN_BUTTON_XPATH);

    public void enterLogin(String login) {
        userNameField.shouldBe(visible.because("Поле ввода логина отсутствует")).setValue(login);
    }

    public void enterPassword(String password) {
        passwordField.shouldBe(visible.because("Поле ввода пароля отсутствует")).setValue(password);
    }

    public void clickLoginButton() {
        loginButton.shouldBe(visible.because("Кнопка 'Войти' отсутствует")).click();
    }

    /**
     * Проверяет, отображается ли ошибка авторизации с ожидаемым сообщением.
     *
     * @param expectedMessage Ожидаемое сообщение об ошибке.
     * @return true, если ошибка отображается, иначе false.
     */
    public boolean isErrorMessageDisplayed(String expectedMessage) {
        return $x(String.format(ERROR_MESSAGE_XPATH, expectedMessage))
                .shouldBe(visible.because("Ошибка авторизации не отобразилась"))
                .exists();
    }

    public boolean isUserNameFieldVisible() {
        return userNameField.shouldBe(visible.because("Поле ввода логина отсутствует")).exists();
    }

    public boolean isPasswordFieldVisible() {
        return passwordField.shouldBe(visible.because("Поле ввода пароля отсутствует")).exists();
    }

    public boolean isLoginButtonVisible() {
        return loginButton.shouldBe(visible.because("Кнопка 'Войти' отсутствует")).exists();
    }

}