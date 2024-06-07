import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.Stellarburgers.pageObject.LoginPage;
import ru.yandex.Stellarburgers.pageObject.MainPage;
import ru.yandex.Stellarburgers.pageObject.ProfilePage;

import static Api.ApiUrls.BASE_URI;
import static org.hamcrest.CoreMatchers.containsString;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class SwitchToAndFromPersonalAccountTest extends TemplateData {

    @Rule
    public DriverRule driverRule = new DriverRule();


    @Test
    @DisplayName("Переход в личный кабинет авторизованного пользователяпо клику на «Личный кабинет»")
    @Description("Switch to personal account auth user")
    public void SwitchToPersonalAccountAuthUserTest() {

        new MainPage(driverRule.getDriver())
                .clickLogInAccountButton();
        new LoginPage(driverRule.getDriver())
                .signInUser(user.getEmail(), user.getPassword());
        new MainPage(driverRule.getDriver())
                .clickPersonalAccountButtonAuthUser();
        new ProfilePage(driverRule.getDriver())
                .isAccountTextDisplayed();
        assertThat("Некоректный URL страницы Личного кабинета", driverRule.getDriver().getCurrentUrl(),
                containsString("/profile"));

    }

    @Test
    @DisplayName("Переход в личный кабинет неавторизованного пользователя по клику на «Личный кабинет»")
    @Description("Switch to personal account unauth user")
    public void SwitchToPersonalAccountUnAuthUserTest() {

        new MainPage(driverRule.getDriver())
                .clickPersonalAccountButton();
        boolean actual = new LoginPage(driverRule.getDriver())
                .isSignInButtonDisplayed();
        assertTrue("Личный кабинет не открывается у неавторизованного пользователя", actual);

    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    @Description("Switch from personal account to constructor")
    public void SwitchFromPersonalAccountToConstructorTest() {

        new MainPage(driverRule.getDriver())
                .clickLogInAccountButton();
        new LoginPage(driverRule.getDriver())
                .signInUser(user.getEmail(), user.getPassword());
        new MainPage(driverRule.getDriver())
                .clickPersonalAccountButtonAuthUser();
        boolean actual = new ProfilePage(driverRule.getDriver())
                .clickConstructorButton()
                .isBunsIsDisplayed();
        assertTrue("Конструктор не открывается", actual);

    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    @Description("Switch from personal account to constructor  to logo")
    public void SwitchFromPersonalAccountToConstructorToLogoTest() {

        new MainPage(driverRule.getDriver())
                .clickLogInAccountButton();
        new LoginPage(driverRule.getDriver())
                .signInUser(user.getEmail(), user.getPassword());
        new MainPage(driverRule.getDriver())
                .clickPersonalAccountButtonAuthUser();
        boolean actual = new ProfilePage(driverRule.getDriver())
                .clickLogoButton()
                .isBunsIsDisplayed();
        assertTrue("Главная страница не открывается", actual);

    }


}
