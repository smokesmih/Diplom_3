import User.User;
import User.UsersMethods;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalAccountPage;

import java.util.concurrent.TimeUnit;
@DisplayName("Проверка перехода в конструктор")
public class OpenConstructorPageTest {
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site";
    private WebDriver driver;
    private Faker faker = new Faker();
    private User user;

    @Before
    public void setUp() {
        user = new User(faker.internet().emailAddress(), faker.internet().password(7,13), String.valueOf(faker.name()));
        UsersMethods.createUser(user);
        driver = WebDriverFactory.createWebDriver();
        driver.get(PAGE_URL);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
        UsersMethods.deleteUser(UsersMethods.getAuthToken(user));
    }

    @Test
    @DisplayName("Проверка перехода из ЛК в конструктор по клику на Конструктор")
    public  void openPersonalAccountWithButton(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickConstructorButton();
        Assert.assertTrue("Ошибка при переходе из ЛК в конструктор", mainPage.createBurgerTextISDisplayed());
    }
    @Test
    @DisplayName("Проверка перехода из ЛК в конструктор по клику на Логотип")
    public  void openPersonalAccountWithLogo(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickStellarBurgerLogo();
        Assert.assertTrue("Ошибка при переходе из ЛК в конструктор", mainPage.createBurgerTextISDisplayed());
    }


}
