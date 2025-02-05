package ru.yandex.pages;


import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;


// Класс главной страницы
public class HomePageSamokat {

    private final WebDriver driver;
    //Вопрос и стрелка  в разделе о важном
    private final By answerId;
    //Ответ в разделе о важном
    private final By questionId;


    // конструктор класса
    public HomePageSamokat(WebDriver driver,By questionId,By answerId) {
        this.driver = driver;
        this.questionId = questionId;
        this.answerId = answerId;

    }


    // проскролить до раздела о важном и проверить вопрос
    public void scrollAndCheckQuestion(String question) {
        WebElement element = driver.findElement(questionId);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.getText();
        MatcherAssert.assertThat(element.getText(),is(question));

    }

    // кликнуть и проверить ответ
    public void clickAndCheckAnswer(String answer) {
        driver.findElement(questionId).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(answerId));
        String result = driver.findElement(answerId).getText();
        MatcherAssert.assertThat(result, is(answer));

    }

}


