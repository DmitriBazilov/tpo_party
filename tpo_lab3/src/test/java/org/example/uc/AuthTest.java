package org.example.uc;

import org.example.Utils;
import org.example.pages.StartPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthTest {

    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    void loginTest() {
        WebDriver webDriver = Utils.getDriver();

        StartPage startPage = new StartPage(webDriver);
        webDriver.get(Utils.BASE_URL);
        startPage.doLogin();

        WebElement verification = Utils.getElementBySelector(webDriver, By.xpath("//*[@id=\"app-wrapper\"]/div[3]/div/div[2]"));

        assertNotNull(verification);

        webDriver.quit();

    }


    @Test
    void logoutTest() {
        WebDriver webDriver = Utils.getDriver();

        StartPage startPage = new StartPage(webDriver);
        webDriver.get(Utils.BASE_URL);
        startPage.doLogin();
        startPage.doLogout();
        WebElement loginButton = Utils.getElementBySelector(webDriver, By.xpath("//*[@id=\"app-wrapper\"]/div[1]/header/div[6]/a[1]"));
        assertNotNull(loginButton);

        webDriver.quit();
    }

}
