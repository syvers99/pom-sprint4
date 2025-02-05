package ru.yandex;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.pages.CookiePageSamokat;
import ru.yandex.pages.OrderPageSamokat;

import static ru.yandex.pages.ConfigMap.*;

@RunWith(Parameterized.class)
public class TestOrder {
    private  WebDriver driver;
    private final String browser;
    private final String[] profile;
    private final String rent;
    private final By station;
    private final By buttonDate;
    private final By buttonOrder;



    public TestOrder(String browser, String[] profile, String rent, By station, By buttonDate, By buttonOrder) {
        this.browser = browser;
        this.profile = profile;
        this.rent = rent;
        this.station = station;
        this.buttonDate = buttonDate;
        this.buttonOrder = buttonOrder;


    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {CHROME,profile_1,comment_rent_1,station_profile_1,date_rent_1,buttonOrder_high},
                {CHROME,profile_2,comment_rent_1,station_profile_2,date_rent_2,buttonOrder_high},
                {CHROME,profile_1,comment_rent_1,station_profile_1,date_rent_1,buttonOrder_low},
                {CHROME,profile_2,comment_rent_1,station_profile_2,date_rent_2,buttonOrder_low},
                {FIREFOX,profile_1,comment_rent_1,station_profile_1,date_rent_1,buttonOrder_high},
                {FIREFOX,profile_2,comment_rent_1,station_profile_2,date_rent_2,buttonOrder_high},
                {FIREFOX,profile_1,comment_rent_1,station_profile_1,date_rent_1,buttonOrder_low},
                {FIREFOX,profile_2,comment_rent_1,station_profile_2,date_rent_2,buttonOrder_low}

        };
    }


    @Before
    public void startUp() {
        // выбор браузера
        if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        // переход на страницу тестового приложения
        driver.get(BASE_URL);
        //закрываем экран с куки
        CookiePageSamokat objCookiePage = new CookiePageSamokat(driver);
        objCookiePage.closeScreen();


    }

    @Test
    public void checkPositiveFlowMakeOrder() {
        OrderPageSamokat objOrderPage = new OrderPageSamokat(driver,station,buttonDate,buttonOrder);
        //1. Кликнуть на кнопку "Заказать"
        objOrderPage.clickOrder();
        //2. Заполнить форму "Для кого самокат"
        objOrderPage.fillProfile(profile);
        //3. Кликнуть на кнопку "Далее"
        objOrderPage.clickNext();
        //4. Заполнить форму "Про аренду"
        objOrderPage.fillRent(rent);
        //5. Кликнуть на кнопку "Заказать/Да"
        objOrderPage.sendOrder();
        //6. Проверить номер нового заказа
        objOrderPage.checkOrderNumber();


    }

    @After
    public void tearDown() {
        // Закрываем браузер
        driver.quit();
    }
}



