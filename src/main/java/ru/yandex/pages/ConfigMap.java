package ru.yandex.pages;

import org.openqa.selenium.By;

public class ConfigMap {
        public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
        public static final String IMPORTANT_0 = "Сколько это стоит? И как оплатить?";
        public static final String ANSWER_0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        public static final String IMPORTANT_1 = "Хочу сразу несколько самокатов! Так можно?";
        public static final String ANSWER_1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        public static final String IMPORTANT_2 = "Как рассчитывается время аренды?";
        public static final String ANSWER_2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        public static final String IMPORTANT_3 = "Можно ли заказать самокат прямо на сегодня?";
        public static final String ANSWER_3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        public static final String IMPORTANT_4 = "Можно ли продлить заказ или вернуть самокат раньше?";
        public static final String ANSWER_4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        public static final String IMPORTANT_5 = "Вы привозите зарядку вместе с самокатом?";
        public static final String ANSWER_5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        public static final String IMPORTANT_6 = "Можно ли отменить заказ?";
        public static final String ANSWER_6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        public static final String IMPORTANT_7 = "Я живу за МКАДом, привезёте?";
        public static final String ANSWER_7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        public static final String[] profile_1 = {"Иван","Годунов","Красногорский бульвар","89663090817"};
        public static final String[] profile_2 = {"Владимир","Шумов","Тверская улица","89313090817"};
        public static final String comment_rent_1 = "Оставьте у дверей";
        public static final String FIREFOX = "Firefox";
        public static final String CHROME = "Chrome";
        public static final String[] location = {"Button_Button__ra12g","Button_Button__ra12g Button_Middle__1CSJM"};
        public static final String[] stat ={ "Сокольники","Мякинино"};
        public static final String[] date ={ "Choose четверг, 6-е февраля 2025 г.","Choose понедельник, 17-е февраля 2025 г."};
        // Кнопка выбора станции метро в форме заказа
        public static final By station_profile_1 = By.xpath(String.format(".//button/div[text()='%s']",stat[0]));
        public static final By station_profile_2 = By.xpath(String.format(".//button/div[text()='%s']",stat[1]));
        // Кнопка выбора даты в форме заказа
        public static final By date_rent_1 = By.xpath(String.format(".//div[@aria-label='%s']",date[0]));
        public static final By date_rent_2 = By.xpath(String.format(".//div[@aria-label='%s']",date[1]));
        // Верхняя кнопка заказа на главной странице
        public static final By buttonOrder_high = By.xpath(String.format(".//button[@class='%s']",location[0]));
        // Нижняя кнопка заказа на главной странице
        public static final By buttonOrder_low = By.xpath(String.format(".//button[@class='%s']",location[1]));
        // Поля вопроса и ответа в разделе о важном
        public static final By QUESTION_ID_0 = By.id("accordion__heading-0");
        public static final By ANSWER_ID_0= By.id("accordion__panel-0");
        public static final By QUESTION_ID_1 = By.id("accordion__heading-1");
        public static final  By ANSWER_ID_1= By.id("accordion__panel-1");
        public static final By QUESTION_ID_2 = By.id("accordion__heading-2");
        public static final  By ANSWER_ID_2= By.id("accordion__panel-2");
        public static final By QUESTION_ID_3 = By.id("accordion__heading-3");
        public static final  By ANSWER_ID_3= By.id("accordion__panel-3");
        public static final By QUESTION_ID_4 = By.id("accordion__heading-4");
        public static final  By ANSWER_ID_4= By.id("accordion__panel-4");
        public static final By QUESTION_ID_5 = By.id("accordion__heading-5");
        public static final  By ANSWER_ID_5= By.id("accordion__panel-5");
        public static final By QUESTION_ID_6 = By.id("accordion__heading-6");
        public static final  By ANSWER_ID_6= By.id("accordion__panel-6");
        public static final By QUESTION_ID_7 = By.id("accordion__heading-7");
        public static final  By ANSWER_ID_7= By.id("accordion__panel-7");


    }

