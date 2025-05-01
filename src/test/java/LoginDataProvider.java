import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class LoginDataProvider {

    public static Stream<Arguments> loginData() {
        return Stream.of(
                Arguments.of("validUser", "validPassword", null),
                Arguments.of("invalidUser", "invalidPassword", "Неправильно указан логин и/или пароль"),
                Arguments.of("", "any_password", "Введите логин"),
                Arguments.of("any_login", "", "Введите пароль")
        );
    }
}
