package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    private WebDriver driver;

    // Надпись В этом разделе вы можете изменить свои персональные данные
    private By accountPageText = By.xpath("//p[text()='В этом разделе вы можете изменить свои персональные данные']");
    // Кнопка Конструктор
    private By constructorButton = By.xpath("//p[text()='Конструктор']");
    // Лого Stellar Burger
    private By stellarBurgerLogo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    // Кнопка Выйти
    private By logOutButton = By.xpath("//button[text()='Выход']");


    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка отображения надписи В этом разделе вы можете изменить свои персональные данные")
    public boolean getAccountPageTextISDisplayed() {
        return driver.findElement(accountPageText).isDisplayed();
    }
    @Step("Клик по кнопке Конструктор")
    public void clickConstructorButton() {
         driver.findElement(constructorButton).click();
    }

    @Step("Клик по лого Stellar Burger")
    public void clickStellarBurgerLogo() {
         driver.findElement(stellarBurgerLogo).click();
    }
    @Step("Клик кнопке Выйти")
    public void clicklogOutButton() {
        driver.findElement(logOutButton).click();
    }

}


