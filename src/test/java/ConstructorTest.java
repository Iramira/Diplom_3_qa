import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.Stellarburgers.pageObject.MainPage;

import static Api.ApiUrls.BASE_URI;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConstructorTest {

    @Rule
    public DriverRule driverRule = new DriverRule();


    @Test
    @DisplayName("Переход к разделу Булки")
    @Description("Go to the bun section")
    public void GoToTheBunSectionTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage
                .clickFillingsTab();
        boolean actual = mainPage
                .clickBunsTab()
                .isBunsIsDisplayed();


        assertThat("Не перешел в раздел Булки", actual);
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    @Description("Go to the sauces section")
    public void GoToTheSaucesSectionTest() {


        boolean actual = new MainPage(driverRule.getDriver())
                .clickSaucesTab()
                .isSaucesIsDisplayed();

        assertThat("Не перешел в раздел Соусы", actual);
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    @Description("Go to the fillings section")
    public void GoToTheFillingsSectionTest() {

        boolean actual = new MainPage(driverRule.getDriver())
                .clickFillingsTab()
                .isFillingsIsDisplayed();


        assertThat("Не перешел в раздел Начинки", actual);
    }
}
