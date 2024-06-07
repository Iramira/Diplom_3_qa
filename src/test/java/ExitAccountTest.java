import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.Stellarburgers.pageObject.LoginPage;
import ru.yandex.Stellarburgers.pageObject.MainPage;
import ru.yandex.Stellarburgers.pageObject.ProfilePage;
import static Api.ApiUrls.BASE_URI;
import static org.junit.Assert.assertTrue;

public class ExitAccountTest extends TemplateData{

    @Rule
    public DriverRule driverRule = new DriverRule();


    @Test
    @DisplayName("Выход из акаунта по кнопке «Выйти» в личном кабинете")
    @Description("Exit account with button Exit")
    public void exitAccountWithButtonExit() {


        new MainPage(driverRule.getDriver())
                .clickPersonalAccountButton()
                .signInUser(user.getEmail(), user.getPassword())
                .clickPersonalAccountButton();

        new ProfilePage(driverRule.getDriver())
                .clickExitButton();

        boolean actual = new LoginPage(driverRule.getDriver())
                .isSignInButtonDisplayed();

        assertTrue("Выход из акаунта не совершен", actual);

    }

}
