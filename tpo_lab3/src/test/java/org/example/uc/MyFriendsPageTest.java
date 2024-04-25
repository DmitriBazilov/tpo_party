package org.example.uc;

import org.example.Utils;
import org.example.pages.StartPage;
import org.example.pages.MyFriendsPage;
import org.example.pages.UserPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyFriendsPageTest {

    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }


    void sendFriendRequest() {
        WebDriver webDriver = Utils.getDriver();

        StartPage mainPage = new StartPage(webDriver);
        webDriver.get(Utils.BASE_URL);
        mainPage.doRegister();
        Utils.waitUntilPageLoads(webDriver, 10);
        UserPage userPage = new UserPage(webDriver);
        webDriver.get(Utils.SECOND_USER_URL);
        Utils.waitUntilPageLoads(webDriver, 10);

        WebElement button = Utils.getElementBySelector(webDriver, By.xpath("//*[@id=\"secondary-header\"]/div/div[3]/button"));
        String buttonText = button.getText();
        if (buttonText.contains("Не дружить")) {
            button.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {
            }
        }
        if (!buttonText.contains("Отменить")) {
            userPage.addFriend();
            WebElement addFriendButton = Utils.getElementBySelector(webDriver, By.xpath("//*[@id=\"secondary-header\"]/div/div[3]/button"));
            buttonText = addFriendButton.getText();
        }
        assertTrue(buttonText.contains("Отменить"));

        webDriver.quit();
    }


}
