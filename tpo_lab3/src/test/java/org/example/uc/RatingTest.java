package org.example.uc;

import lombok.SneakyThrows;
import org.example.Utils;
import org.example.pages.RatingPage;
import org.example.pages.StartPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RatingTest {

    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @SneakyThrows
    @Test
    void likeTest() {
        WebDriver webDriver = Utils.getDriver();
        StartPage mainPage = new StartPage(webDriver);
        webDriver.get(Utils.BASE_URL);
        mainPage.doLogin();

        RatingPage ratingPage = new RatingPage(webDriver);
        webDriver.get(Utils.RATING_PAGE);

        Thread.sleep(1000);
        String fName = Utils.getElementBySelector(webDriver, By.xpath("//*[@id=\"app-wrapper\"]/div[3]/div/div[2]/div/div/section/div/div[1]/div[7]/div[2]/div[2]/div[1]/div[1]/div/div[1]")).getText();
        ratingPage.like();

        Thread.sleep(1000);
        String sName = Utils.getElementBySelector(webDriver, By.xpath("//*[@id=\"app-wrapper\"]/div[3]/div/div[2]/div/div/section/div/div[1]/div[7]/div[2]/div[2]/div[1]/div[1]/div/div[1]")).getText();
        Assertions.assertNotEquals(fName, sName);
        webDriver.quit();
    }

    @SneakyThrows
    @Test
    void skipTest() {
        WebDriver webDriver = Utils.getDriver();
        StartPage startPage = new StartPage(webDriver);
        webDriver.get(Utils.BASE_URL);
        startPage.doLogin();

        RatingPage ratingPage = new RatingPage(webDriver);
        webDriver.get(Utils.RATING_PAGE);

        Thread.sleep(1000);
        String fName = Utils.getElementBySelector(webDriver, By.xpath("//*[@id=\"app-wrapper\"]/div[3]/div/div[2]/div/div/section/div/div[1]/div[7]/div[2]/div[2]/div[1]/div[1]/div/div[1]")).getText();
        ratingPage.skip();

        Thread.sleep(1000);
        String sName = Utils.getElementBySelector(webDriver, By.xpath("//*[@id=\"app-wrapper\"]/div[3]/div/div[2]/div/div/section/div/div[1]/div[7]/div[2]/div[2]/div[1]/div[1]/div/div[1]")).getText();
        Assertions.assertNotEquals(fName, sName);
        webDriver.quit();
    }
}
