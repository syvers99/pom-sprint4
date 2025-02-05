package ru.yandex;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.After;
import org.junit.Test;
import ru.yandex.pages.CookiePageSamokat;
import ru.yandex.pages.HomePageSamokat;

import static ru.yandex.pages.ConfigMap.*;

@RunWith(Parameterized.class)
public class TestImportant {
    private final String browser;
    private final String answer;
    private final String question;
    private final By answerId;
    private final By questionId;
    private WebDriver driver;


    public TestImportant(String browser, String question, String answer, By questionId, By answerId) {
        this.browser = browser;
        this.answer = answer;
        this.question = question;
        this.questionId = questionId;
        this.answerId = answerId;

    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {FIREFOX,IMPORTANT_0, ANSWER_0, QUESTION_ID_0, ANSWER_ID_0},
                {FIREFOX,IMPORTANT_1, ANSWER_1, QUESTION_ID_1, ANSWER_ID_1},
                {FIREFOX,IMPORTANT_2, ANSWER_2, QUESTION_ID_2, ANSWER_ID_2},
                {FIREFOX,IMPORTANT_3, ANSWER_3, QUESTION_ID_3, ANSWER_ID_3},
                {FIREFOX,IMPORTANT_4, ANSWER_4, QUESTION_ID_4, ANSWER_ID_4},
                {FIREFOX,IMPORTANT_5, ANSWER_5, QUESTION_ID_5, ANSWER_ID_5},
                {FIREFOX,IMPORTANT_6, ANSWER_6, QUESTION_ID_6, ANSWER_ID_6},
                {FIREFOX,IMPORTANT_7, ANSWER_7, QUESTION_ID_7, ANSWER_ID_7},
                {CHROME,IMPORTANT_0, ANSWER_0, QUESTION_ID_0, ANSWER_ID_0},
                {CHROME,IMPORTANT_1, ANSWER_1, QUESTION_ID_1, ANSWER_ID_1},
                {CHROME,IMPORTANT_2, ANSWER_2, QUESTION_ID_2, ANSWER_ID_2},
                {CHROME,IMPORTANT_3, ANSWER_3, QUESTION_ID_3, ANSWER_ID_3},
                {CHROME,IMPORTANT_4, ANSWER_4, QUESTION_ID_4, ANSWER_ID_4},
                {CHROME,IMPORTANT_5, ANSWER_5, QUESTION_ID_5, ANSWER_ID_5},
                {CHROME,IMPORTANT_6, ANSWER_6, QUESTION_ID_6, ANSWER_ID_6},
                {CHROME,IMPORTANT_7, ANSWER_7, QUESTION_ID_7, ANSWER_ID_7},
        };
    }


    @Before
    public void startUp() {
        //выбор браузера
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
    public void checkAboutImportant() {
        HomePageSamokat objHomePage = new HomePageSamokat(driver,questionId,answerId);
        //проскролить до раздела о важном и проверить вопрос
        objHomePage.scrollAndCheckQuestion(question);
        // кликнуть на стрелку и проверить ответ
        objHomePage.clickAndCheckAnswer(answer);

    }

    @After
    public void tearDown() {
        // Закрываем браузер
        driver.quit();
    }
}