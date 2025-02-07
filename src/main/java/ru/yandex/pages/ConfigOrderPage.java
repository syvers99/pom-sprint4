package ru.yandex.pages;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static ru.yandex.pages.ConfigMap.*;

public class ConfigOrderPage {

    public static final Map<String, String> PROFILE_IVAN;
    static  {
        PROFILE_IVAN = new HashMap<>();
        PROFILE_IVAN.put("name", "Иван");
        PROFILE_IVAN.put("secondName", "Годунов");
        PROFILE_IVAN.put("address", "Красногорский бульвар");
        PROFILE_IVAN.put("phone", "89313090817");
    }
    public static final Map<String, String> PROFILE_VLAD;
    static  {
        PROFILE_VLAD = new HashMap<>();
        PROFILE_VLAD.put("name", "Владимир");
        PROFILE_VLAD.put("secondName", "Шумов");
        PROFILE_VLAD.put("address", "Тверская улица");
        PROFILE_VLAD.put("phone", "89313098177");
    }
    public static final String ORDER_NUMBER = "Номер заказа:";
    public static final String COMMENT_RENT_ONE = "Оставьте у дверей";
    public static final String[] LOCATION = {"Button_Button__ra12g","Button_Button__ra12g Button_Middle__1CSJM"};
    public static final String[] STAT ={ "Сокольники","Мякинино"};
    public static final String[] DATE ={ "Choose четверг, 6-е февраля 2025 г.","Choose понедельник, 17-е февраля 2025 г."};

    // Кнопка выбора станции метро в форме заказа
    public static final By STATION_PROFILE_IVAN = By.xpath(String.format(".//button/div[text()='%s']", STAT[0]));
    public static final By STATION_PROFILE_VLAD = By.xpath(String.format(".//button/div[text()='%s']", STAT[1]));
    // Кнопка выбора даты в форме заказа
    public static final By DATE_RENT_IVAN = By.xpath(String.format(".//div[@aria-label='%s']", DATE[0]));
    public static final By DATE_RENT_VLAD = By.xpath(String.format(".//div[@aria-label='%s']", DATE[1]));
    // Верхняя кнопка заказа на главной странице
    public static final By BUTTON_ORDER_HIGH = By.xpath(String.format(".//button[@class='%s']", LOCATION[0]));
    // Нижняя кнопка заказа на главной странице
    public static final By BUTTON_ORDER_LOW = By.xpath(String.format(".//button[@class='%s']", LOCATION[1]));
    //заголовок формы Для кого самокат
    public static final By formTitle = By.className("Order_Header__BZXOb");
    // поле Имя в форме Для кого самокат
    public static final By formFieldName = By.xpath(".//input[@placeholder='* Имя']");
    // поле Адрес в форме Для кого самокат
    public static final By formFieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // поле станция метро в форме Для кого самокат
    public static final By formFieldSubway = By.xpath(".//input[@placeholder='* Станция метро']");
    // поле фамилия в форме Для кого самокат
    public static final By formFieldSecondName = By.xpath(".//input[@placeholder='* Фамилия']");
    // поле телефон в форме Для кого самокат
    public static final By formFieldPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // кнопка Далее под формой Для кого самокат
    public static final By buttonNext = By.xpath(".//button[text()='Далее']");
    // заголовок формы Про аренду
    public static final By rentTitle = By.xpath(".//div[text()='Про аренду']");
    // поле дата в форме Про аренду
    public static final By rentFieldDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // поле комментарий в форме Про аренду
    public static final By rentFieldComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // поле выбора цвета  в форме Про аренду
    public static final By rentFieldColor = By.xpath(".//input[@id='black']");
    //// поле выбора срока аренды  в форме Про аренду
    public static final By rentFieldPeriod = By.xpath(".//div[text()='* Срок аренды']");
    // кнопка выбора срока аренды
    public static final By buttonPeriod = By.xpath(".//div[text()='двое суток']");
    // кнопка Заказать под формой про Аренду
    public static final By rentButtonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // кнопка подтверждения заказа на модальном экране
    public static final By buttonYes = By.xpath(".//button[text()='Да']");
    // Заголовок экрана Заказ оформлен
    public static final By screenOrderPlaced = By.xpath(".//div[text()='Заказ оформлен']");
    // Поле с номером заказа на Экране заказ оформлен
    public static final By orderNumber = By.className("Order_Text__2broi");
}
