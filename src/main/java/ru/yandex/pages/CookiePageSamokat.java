package ru.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




// Класс страницы c куки
public class CookiePageSamokat {
    private final WebDriver driver;
    // Кнопка Закрыть инфоэкран пр куки
    private final By buttonId = By.id("rcc-confirm-button");


    // конструктор класса
    public CookiePageSamokat(WebDriver driver) {
        this.driver = driver;


    }


    // проскролить до раздела о важном и проверить вопрос
    public void closeScreen() {
        driver.findElement(buttonId).click();

    }

}

