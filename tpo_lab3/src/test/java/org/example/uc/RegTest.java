package org.example.uc;

import org.example.Utils;
import org.example.pages.StartPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegTest {

    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    void registerTest() {
        WebDriver webDriver = Utils.getDriver();

        StartPage mainPage = new StartPage(webDriver);
        webDriver.get(Utils.BASE_URL);
        mainPage.doRegister();

        WebElement verification = Utils.getElementBySelector(webDriver, By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/main"));

        assertNotNull(verification);

        webDriver.quit();
    }

}
