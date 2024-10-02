package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage {
    private WebDriver driver;

    //Кнопка Зарегистрироваться
    private By registerButton = By.xpath("//a[text()='Зарегистрироваться']");
    //Кнопка Войти
    private By loginButton = By.xpath("//button[text()='Войти']");
    //Кнопка Восстановаить пароль
    private By recoverPasswordButton = By.xpath("//a[text()='Восстановить пароль']");
    //Поле для ввода email
    private By emailInput = By.xpath("(//input[@class = 'text input__textfield text_type_main-default'])[1]");
    //Поле для ввода пароля
    private By passwordInput = By.xpath("(//input[@class = 'text input__textfield text_type_main-default'])[2]");
    //Тест вход
    private By loginText = By.xpath("//h2[text()='Вход']");




    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке зарегистрироваться в личном кабинете")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    @Step("Проверка отображения кнопки Войти")
    public boolean orderResultISDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }

    @Step("Заполнение поля email на странице регистрации")
    public void setEmailInput(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Заполнение поля пароль на странице регистрации")
    public void setPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    @Step("Клик по кнопке Войти в личном кабинете")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Логин в личном кабинете")
    public void login(String email, String password) {
        setEmailInput(email);
        setPasswordInput(password);
        clickLoginButton();

    }
    @Step("Клик по кнопке восстановить пароль в личном кабинете")
    public void clickRecoverPasswordButton() {
        driver.findElement(recoverPasswordButton).click();
    }
    @Step("Проверка отображения текста Вход")
    public boolean loginTextISDisplayed() {
        return driver.findElement(loginText).isDisplayed();
    }


}
