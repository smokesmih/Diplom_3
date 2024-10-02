import User.User;
import User.UsersMethods;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.LoginPage;
import pages.RegisterPage;

import java.util.concurrent.TimeUnit;

@DisplayName("Проверка регистрации клиента")
public class RegistrationTest {
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site";
    private WebDriver driver;
    private Faker faker = new Faker();
    private User user;

    @Before
    public void setUp() {
        driver = WebDriverFactory.createWebDriver();
        driver.get(PAGE_URL);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка успешной регистрации клиента")
    public void registerUserPositive() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();
        RegisterPage registerPage = new RegisterPage(driver);
        user = new User(faker.internet().emailAddress(), faker.internet().password(7,12), String.valueOf(faker.name()));
        registerPage.getRegistration(user.getName(), user.getEmail(), user.getPassword());
        Assert.assertTrue("Ошибка регистрации", loginPage.orderResultISDisplayed());
        UsersMethods.deleteUser(UsersMethods.getAuthToken(user));
    }
    @Test
    @DisplayName("Проверка попытки регистрации клиента с паролем менее 6ти символов")
    public void registerUserShortPass() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.getRegistration(String.valueOf(faker.name()), faker.internet().emailAddress(), faker.internet().password(2,5));
        Assert.assertTrue("Регистрации с паролем меньше 6ти символом недопустима", registerPage.wrongPasswodISDisplayed());
    }

}
