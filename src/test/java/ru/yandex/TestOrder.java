package ru.yandex;


import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.pages.CookiePageSamokat;
import ru.yandex.pages.OrderPageSamokat;

import java.util.Map;

import static ru.yandex.pages.ConfigMap.*;
import static ru.yandex.pages.ConfigOrderPage.*;

@RunWith(Parameterized.class)
public class TestOrder {
    private final Map<String, String> profile;
    private final String rent;
    private final By station;
    private final By buttonDate;
    private final By buttonOrder;


    public TestOrder(Map<String, String> profile, String rent, By station, By buttonDate, By buttonOrder) {
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
                //Кейсы на Верхнюю кнопку Заказать
                {PROFILE_IVAN, COMMENT_RENT_ONE, STATION_PROFILE_IVAN, DATE_RENT_IVAN, BUTTON_ORDER_HIGH},
                {PROFILE_VLAD, COMMENT_RENT_ONE, STATION_PROFILE_VLAD, DATE_RENT_VLAD, BUTTON_ORDER_HIGH},
                //Кейсы на Нижнюю кнопку Заказать
                {PROFILE_IVAN, COMMENT_RENT_ONE, STATION_PROFILE_IVAN, DATE_RENT_IVAN, BUTTON_ORDER_LOW},
                {PROFILE_VLAD, COMMENT_RENT_ONE, STATION_PROFILE_VLAD, DATE_RENT_VLAD, BUTTON_ORDER_LOW}
        };
    }

    @Rule
    public DriverRule factory = new DriverRule();


    @Test
    public void checkPositiveFlowMakeOrder() throws Exception {
        WebDriver driver = factory.getDriver();
        // переход на страницу тестового приложения
        driver.get(BASE_URL);
        //закрываем экран с куки
        CookiePageSamokat objCookiePage = new CookiePageSamokat(driver);
        objCookiePage.closeScreen();
        //1. Кликнуть на кнопку "Заказать"
        OrderPageSamokat objOrderPage = new OrderPageSamokat(driver, station, buttonDate, buttonOrder);
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
}



