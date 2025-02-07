package ru.yandex;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import ru.yandex.pages.CookiePageSamokat;
import ru.yandex.pages.HomePageSamokat;
import static ru.yandex.pages.ConfigHomePage.*;
import static ru.yandex.pages.ConfigMap.*;

@RunWith(Parameterized.class)
public class TestImportant {
    private final String answer;
    private final String question;
    private final By answerId;
    private final By questionId;



    public TestImportant( String question, String answer, By questionId, By answerId) {
        this.answer = answer;
        this.question = question;
        this.questionId = questionId;
        this.answerId = answerId;

    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {IMPORTANT_0, ANSWER_0, QUESTION_ID_0, ANSWER_ID_0},
                {IMPORTANT_1, ANSWER_1, QUESTION_ID_1, ANSWER_ID_1},
                {IMPORTANT_2, ANSWER_2, QUESTION_ID_2, ANSWER_ID_2},
                {IMPORTANT_3, ANSWER_3, QUESTION_ID_3, ANSWER_ID_3},
                {IMPORTANT_4, ANSWER_4, QUESTION_ID_4, ANSWER_ID_4},
                {IMPORTANT_5, ANSWER_5, QUESTION_ID_5, ANSWER_ID_5},
                {IMPORTANT_6, ANSWER_6, QUESTION_ID_6, ANSWER_ID_6},
                {IMPORTANT_7, ANSWER_7, QUESTION_ID_7, ANSWER_ID_7}
        };
    }


   @Rule
   public DriverRule factory = new DriverRule();

    @Test
    public void checkAboutImportant() throws Exception {
        WebDriver driver = factory.getDriver();
        driver.get(BASE_URL);
        HomePageSamokat objHomePage = new HomePageSamokat(driver,questionId,answerId);
        //закрываем экран с куки
        CookiePageSamokat objCookiePage = new CookiePageSamokat(driver);
        objCookiePage.closeScreen();
        //проскролить до раздела о важном и проверить вопрос
        objHomePage.scrollAndCheckQuestion(question);
        // кликнуть на стрелку и проверить ответ
        objHomePage.clickAndCheckAnswer(answer);

    }

}