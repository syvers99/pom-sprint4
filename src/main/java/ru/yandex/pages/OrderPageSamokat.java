package ru.yandex.pages;


import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static ru.yandex.pages.ConfigOrderPage.*;


// Класс страницы заказа
public class OrderPageSamokat {
    private final WebDriver driver;
    // селектор станции метро
    private final By station;
    // селектор кнопки Заказать на главной странице
    private final By buttonOrder;
    // кнопка выбора даты в форме Про аренду
    private final By buttonDate;


    // конструктор класса
    public OrderPageSamokat(WebDriver driver, By station, By buttonDate, By buttonOrder) {
        this.driver = driver;
        this.station = station;
        this.buttonDate = buttonDate;
        this.buttonOrder = buttonOrder;
    }




    //1. Кликнуть на кнопку "Заказать"
    public void clickOrder() {
        WebElement element = driver.findElement(buttonOrder);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonOrder));
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(formTitle));

    }
    //2. Заполнить форму "Для кого самокат"
    public void fillProfile(Map<String, String> profile) {
        driver.findElement(formFieldName).sendKeys(profile.get("name"));
        driver.findElement(formFieldSecondName).sendKeys(profile.get("secondName"));
        driver.findElement(formFieldAddress).sendKeys(profile.get("address"));
        driver.findElement(formFieldSubway).click();
        WebElement element = driver.findElement(station);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(station));
        element.click();
        driver.findElement(formFieldPhone).sendKeys(profile.get("phone"));

    }
    //3. Кликнуть на кнопку "Далее"

    public void clickNext() {
        driver.findElement(buttonNext).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(rentTitle));

    }
    //4. Заполнить форму "Про аренду"
    public void fillRent(String rent) {
        driver.findElement(rentFieldDate).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonDate));
        driver.findElement(buttonDate).click();
        driver.findElement(rentFieldPeriod).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonPeriod));
        driver.findElement(buttonPeriod).click();
        driver.findElement(rentFieldColor).click();
        driver.findElement(rentFieldComment).sendKeys(rent);

    }

    //5. Кликнуть на кнопку "Заказать/Да"
    public void sendOrder() {
        driver.findElement(rentButtonOrder).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonYes));
        driver.findElement(buttonYes).click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(screenOrderPlaced));
    }
    //6. Проверить номер нового заказа
    public void checkOrderNumber() {
        String result = driver.findElement(orderNumber).getText();
        MatcherAssert.assertThat(result,containsString(ORDER_NUMBER));
        System.out.println(result);

    }



}