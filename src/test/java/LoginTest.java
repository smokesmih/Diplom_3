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
import pages.RecoverPasswordPage;
import pages.RegisterPage;

import java.util.concurrent.TimeUnit;

@DisplayName("Проверка входа через разные кнопки")
public class LoginTest {
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
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
        UsersMethods.deleteUser(UsersMethods.getAuthToken(user));
    }

    @Test
    @DisplayName("Проверка входа через главную страницу")
    public  void loginMainPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
         loginPage.login(user.getEmail(), user.getPassword());
        Assert.assertTrue("Ошибка при входе", mainPage.getOrderButtonISDisplayed());

    }
    @Test
    @DisplayName("Проверка входа через «Личный кабинет»")
    public  void loginPersonalAccountPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        Assert.assertTrue("Ошибка при входе", mainPage.getOrderButtonISDisplayed());

    }
    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public  void loginRegisterPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLoginButton();
        loginPage.login(user.getEmail(), user.getPassword());
        Assert.assertTrue("Ошибка при входе", mainPage.getOrderButtonISDisplayed());
    }
    @Test
    @DisplayName("Проверка входа через  кнопку в форме восстановления пароля")
    public  void loginRecoverPasswordPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRecoverPasswordButton();
        RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);
        recoverPasswordPage.clickLoginButton();
        loginPage.login(user.getEmail(), user.getPassword());
        Assert.assertTrue("Ошибка при входе", mainPage.getOrderButtonISDisplayed());
    }
}
