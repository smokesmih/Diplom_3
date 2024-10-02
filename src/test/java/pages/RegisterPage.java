package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage {
    private WebDriver driver;


    //Поле для ввода имя
    private By nameInput = By.xpath("(//input[@class = 'text input__textfield text_type_main-default'])[1]");
    //Поле для ввода email
    private By emailInput = By.xpath("(//input[@class = 'text input__textfield text_type_main-default'])[2]");
    //Поле для ввода пароля
    private By passwordInput = By.xpath("(//input[@class = 'text input__textfield text_type_main-default'])[3]");
    //Кнопка Зарегистрироваться
    private By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    //Надпись некорректный пароль
    private By wrongPasswod = By.xpath("//p[text()='Некорректный пароль']");
    //Кнопка Войти
    private By loginButton = By.xpath("//a[text()='Войти']");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Заполнение поля имя на странице регистрации")
    public void setNameInput(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    @Step("Заполнение поля email на странице регистрации")
    public void setEmailInput(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Заполнение поля пароль на странице регистрации")
    public void setPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Клик по кнопке зарегистрироваться на странице регистрации")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Выполнение регистрации на странице регистрации")
    public void getRegistration(String name, String email, String password) {
       setNameInput(name);
       setEmailInput(email);
       setPasswordInput(password);
       clickRegisterButton();
    }
    @Step("Проверка отображения ошибки валидации - Неверный пароль")
    public boolean wrongPasswodISDisplayed() {
        return driver.findElement(wrongPasswod).isDisplayed();
    }
    @Step("Клик по кнопке Войти на странице регистрации")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
