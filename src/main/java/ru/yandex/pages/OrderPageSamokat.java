package ru.yandex.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


// Класс страницы заказа
public class OrderPageSamokat {
    private final WebDriver driver;
    // селектор станции метро
    private final By station;
    // селектор кнопки Заказать на главной странице
    private final By buttonOrder;
    //заголовок формы Для кого самокат
    private final By formTitle = By.className("Order_Header__BZXOb");
    // поле Имя в форме Для кого самокат
    private final By formFieldName = By.xpath(".//input[@placeholder='* Имя']");
    // поле Адрес в форме Для кого самокат
    private final By formFieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // поле станция метро в форме Для кого самокат
    private final By formFieldSubway = By.xpath(".//input[@placeholder='* Станция метро']");
    // поле фамилия в форме Для кого самокат
    private final By formFieldSecondName = By.xpath(".//input[@placeholder='* Фамилия']");
    // поле телефон в форме Для кого самокат
    private final By formFieldPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // кнопка Далее под формой Для кого самокат
    private final By buttonNext = By.xpath(".//button[text()='Далее']");
    // заголовок формы Про аренду
    private final By rentTitle = By.xpath(".//div[text()='Про аренду']");
    // поле дата в форме Про аренду
    private final By rentFieldDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // кнопка выбора даты в форме Про аренду
    private final By buttonDate;
    // поле комментарий в форме Про аренду
    private final By rentFieldComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // поле выбора цвета  в форме Про аренду
    private final By rentFieldColor = By.xpath(".//input[@id='black']");
    //// поле выбора срока аренды  в форме Про аренду
    private final By rentFieldPeriod = By.xpath(".//div[text()='* Срок аренды']");
    // кнопка выбора срока аренды
    private final By buttonPeriod = By.xpath(".//div[text()='двое суток']");
    // кнопка Заказать под формой про Аренду
    private final By rentButtonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // кнопка подтверждения заказа на модальном экране
    private final By buttonYes = By.xpath(".//button[text()='Да']");
    // Заголовок экрана Заказ оформлен
    private final By screenOrderPlaced = By.xpath(".//div[text()='Заказ оформлен']");
    // Поле с номером заказа на Экране заказ оформлен
    private final By orderNumber = By.className("Order_Text__2broi");


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
    public void fillProfile(String[] profile) {
        driver.findElement(formFieldName).sendKeys(profile[0]);
        driver.findElement(formFieldSecondName).sendKeys(profile[1]);
        driver.findElement(formFieldAddress).sendKeys(profile[2]);
        driver.findElement(formFieldSubway).click();
        WebElement element = driver.findElement(station);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(station));
        element.click();
        driver.findElement(formFieldPhone).sendKeys(profile[3]);

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
        System.out.println(driver.findElement(orderNumber).getText());

    }



}