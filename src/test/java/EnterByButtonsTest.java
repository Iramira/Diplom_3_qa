import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import ru.yandex.Stellarburgers.pageObject.LoginPage;
import ru.yandex.Stellarburgers.pageObject.MainPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
public class EnterByButtonsTest extends TemplateData {

    @Rule
    public DriverRule driverRule = new DriverRule();


    @Test
    @DisplayName("Войти профиль по кнопке «Войти в аккаунт» на главной странице")
    @Description("Log in using the log in account button on the main page")
    public void LogInUsingLogInAccountButtonOnTheMainPageTest() {

        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage
                .clickLogInAccountButton()
                .signInUser(user.getEmail(), user.getPassword());

        String actual = mainPage.getBasketButtonText();
        assertThat("Ожидается надпись «Оформить заказ» на кнопке в корзине", actual, equalTo("Оформить заказ"));
    }

    @Test
    @DisplayName("Войти в профиль по кнопке «Личный кабинет»")
    @Description("Sign in with button personal account")
    public void signInWithButtonPersonalAccountTest() {

        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage
                .clickPersonalAccountButtonAuthUser();

        new LoginPage(driverRule.getDriver())
                .clickSignInButton()
                .signInUser(user.getEmail(), user.getPassword());

        String actual = mainPage.getBasketButtonText();
        assertThat("Ожидается надпись «Оформить заказ» на кнопке в корзине", actual, equalTo("Оформить заказ"));
    }


    @Test
    @DisplayName("Войти в профиль по «Войти» в форме регистрации")
    @Description("Sign in with button on registration page")
    public void singInWithButtonOnRegistrationPageTest() {

        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage
                .clickPersonalAccountButton();
        new LoginPage(driverRule.getDriver())
                .clickRegistrationButton()
                .clickSignInButton()
                .signInUser(user.getEmail(), user.getPassword());

        String actual = mainPage.getBasketButtonText();
        assertThat("Ожидается надпись «Оформить заказ» на кнопке в корзине", actual, equalTo("Оформить заказ"));
    }


    @Test
    @DisplayName("Войти в профиль по «Войти» в форме восстановления пароль")
    @Description("Sing in with button on forgot password page")
    public void singInWithButtonOnForgotPasswordPageTest() {

        MainPage mainPage = new MainPage(driverRule.getDriver());
        LoginPage loginPage = new LoginPage(driverRule.getDriver());

        mainPage
                .clickPersonalAccountButton();
        loginPage
                .clickForgotPasswordButton();
        loginPage
                .clickSignInButtonRememberedPassword()
                .signInUser(user.getEmail(), user.getPassword());

        String actual = mainPage.getBasketButtonText();
        assertThat("Ожидается надпись «Оформить заказ» на кнопке в корзине", actual, equalTo("Оформить заказ"));
    }

}
