import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import ru.yandex.Stellarburgers.pageObject.MainPage;
import ru.yandex.Stellarburgers.pageObject.RegistrationPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegistrationTest extends TemplateData{



    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Successful user registration")
    public void successfulUserRegistrationTest() {

        String actual = new MainPage(driverRule.getDriver())
                .clickPersonalAccountButton()
                .clickRegistrationButton()
                .registerUser(user.getName(), user.getEmail(), user.getPassword())
                .signInUser(user.getEmail(), user.getPassword())
                .getBasketButtonText();
        assertThat("Ожидается надпись «Оформить заказ» на кнопке в корзине", actual, equalTo("Оформить заказ"));

    }

    @Test
    @DisplayName("Ошибка при пароле менее 6 символов")
    @Description("Registration with invalid password")
    public void registrationWithInvalidPasswordTest() {


        new MainPage(driverRule.getDriver())
                .clickPersonalAccountButton()
                .clickRegistrationButton()
                .registerUser(user.getName(), user.getEmail(), user.getPassword().substring(0, 4));

        String actual = new RegistrationPage(driverRule.getDriver()).getErrorMessage();

        MatcherAssert.assertThat("Некорректное сообщение об ошибке", actual,equalTo("Некорректный пароль"));


    }

}