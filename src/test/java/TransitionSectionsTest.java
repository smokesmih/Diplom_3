import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@DisplayName("Проверка прехода по разделам Конструктора")
public class TransitionSectionsTest {
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site";
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverFactory.createWebDriver();
        driver.get(PAGE_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @DisplayName("Проверка перехода к разделу начинки")
    @Test
    public  void goToFillingTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingButton();
        Assert.assertTrue("Ошибка при переходе в раздел начинки", mainPage.shellfishImageInScreen());
    }
    @DisplayName("Проверка перехода к разделу соусы")
    @Test
    public  void goToSauceTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauceButton();
        Assert.assertTrue("Ошибка при переходе в раздел начинки", mainPage.spicyXImageInScreen());
    }
    @DisplayName("Проверка перехода к разделу булки")
    @Test
    public  void goToBreadTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingButton();
        mainPage.clickBreadButton();
        Assert.assertTrue("Ошибка при переходе в раздел начинки", mainPage.breadR2D3XImageInScreen());
    }

}
