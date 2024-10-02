package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    private WebDriver driver;


    //Кнопка Личный кабинет
    private By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    //Кнопка Войти в аккаунт
    private By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    //Кнопка Оформить заказ
    private By getOrderButton = By.xpath("//button[text()='Оформить заказ']");
    //Надпись Соберите бургер
    private By createBurgerText = By.xpath("//h1[text()='Соберите бургер']");
    //Кнопка начинки
    private By fillingButton = By.xpath(".//span[text() = 'Начинки']/parent::div");
    //Кнопка соусы
    private By sauceButton = By.xpath(".//span[text() = 'Соусы']/parent::div");
    //Кнопка начинки
    private By breadButton = By.xpath(".//span[text() = 'Булки']/parent::div");
    //Картинка мяса моллюсков
    private By shellfishImage = By.xpath(".//img[@alt='Мясо бессмертных моллюсков Protostomia']");
    //Картинка соуса Spicy-X
    private By spicyXImage = By.xpath(".//img[@alt='Соус Spicy-X']");
    //Картинка булки R2-D3
    private By breadR2D3XImage = By.xpath(".//img[@alt='Флюоресцентная булка R2-D3']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке Личный кабинет на главной странице")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Клик по кнопке Войти в аккаунт на главной странице")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Проверка отображения кнопки Оформить заказ")
    public boolean getOrderButtonISDisplayed() {
        return driver.findElement(getOrderButton).isDisplayed();
    }

    @Step("Проверка надписи кнопки Соберите бургер")
    public boolean createBurgerTextISDisplayed() {
        return driver.findElement(createBurgerText).isDisplayed();
    }

    @Step("Клик по кнопке Начинки")
    public void clickFillingButton() {
        driver.findElement(fillingButton).click();
    }

    @Step("Клик по кнопке Соусы")
    public void clickSauceButton() {
        driver.findElement(sauceButton).click();
    }

    @Step("Клик по кнопке Булки")
    public void clickBreadButton() {
        driver.findElement(breadButton).click();
    }


    @Step("Проверка нахождения Мяса бессмертных моллюсков Protostomia в зоне видимости экрана")
    public boolean shellfishImageInScreen() {

        return
                new WebDriverWait(driver, Duration.ofSeconds(2))
                        .until(
                                driver -> {
                                    Rectangle rect = driver.findElement(shellfishImage).getRect();
                                    Dimension windowSize = driver.manage().window().getSize();
                                    return rect.getX() >= 0
                                            && rect.getY() >= 0
                                            && rect.getX() + rect.getWidth() <= windowSize.getWidth()
                                            && rect.getY() + rect.getHeight() <= windowSize.getHeight();
                                });
    }
    @Step("Проверка нахождения соуса  Spicy-X в зоне видимости экрана")
    public boolean spicyXImageInScreen() {

        return
                new WebDriverWait(driver, Duration.ofSeconds(2))
                        .until(
                                driver -> {
                                    Rectangle rect = driver.findElement(spicyXImage).getRect();
                                    Dimension windowSize = driver.manage().window().getSize();
                                    return rect.getX() >= 0
                                            && rect.getY() >= 0
                                            && rect.getX() + rect.getWidth() <= windowSize.getWidth()
                                            && rect.getY() + rect.getHeight() <= windowSize.getHeight();
                                });
    }
    @Step("Проверка нахождения флюоресцентной булки R2-D3 в зоне видимости экрана")
    public boolean breadR2D3XImageInScreen() {

        return
                new WebDriverWait(driver, Duration.ofSeconds(2))
                        .until(
                                driver -> {
                                    Rectangle rect = driver.findElement(breadR2D3XImage).getRect();
                                    Dimension windowSize = driver.manage().window().getSize();
                                    return rect.getX() >= 0
                                            && rect.getY() >= 0
                                            && rect.getX() + rect.getWidth() <= windowSize.getWidth()
                                            && rect.getY() + rect.getHeight() <= windowSize.getHeight();
                                });
    }


}

