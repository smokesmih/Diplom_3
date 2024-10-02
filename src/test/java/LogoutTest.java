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

@DisplayName("Проверка выхода из аккаунта")
public class LogoutTest {
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
    @DisplayName("Проверка выхода из аккаунта по кнопке Выйти")
    public  void logoutTes(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clicklogOutButton();
        Assert.assertTrue("Ошибка при переходе в личный кабинет", loginPage.loginTextISDisplayed());
    }
}
