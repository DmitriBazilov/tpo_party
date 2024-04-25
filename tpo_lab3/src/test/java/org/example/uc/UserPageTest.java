package org.example.uc;

import org.example.Utils;
import org.example.pages.StartPage;
import org.example.pages.MyFriendsPage;
import org.example.pages.UserPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class UserPageTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    private void deleteFriend() {
        WebDriver webDriver = Utils.getDriver();

        StartPage mainPage = new StartPage(webDriver);
        webDriver.get(Utils.BASE_URL);
        mainPage.doRegister();
        WebElement burgerMenu = Utils.getElementBySelector(webDriver, By.xpath("//*[@id=\"header-profile-tooltip\"]/button"));
        assertNotNull(burgerMenu);

        UserPage userPage = new UserPage(webDriver);
        webDriver.get(Utils.SECOND_USER_URL);

        try {
            userPage.deleteFriend();
        } catch (Exception ignored) {
        }
        webDriver.quit();
    }

    @Test
    void sendFriendRequestTest() {
        WebDriver webDriver = Utils.getDriver();
        deleteFriend();

        StartPage mainPage = new StartPage(webDriver);
        webDriver.get(Utils.BASE_URL);
        mainPage.doRegister();
        UserPage userPage = new UserPage(webDriver);
        webDriver.get(Utils.SECOND_USER_URL);
        userPage.addFriend();
        WebElement addFriendButton = Utils.getElementBySelector(webDriver, By.xpath("//*[@id=\"secondary-header\"]/div/div[3]/button"));
        String buttonText = addFriendButton.getText();
        assertTrue(buttonText.contains("Отменить"));

        webDriver.quit();
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
        try {
            userPage.addFriend();
            WebElement addFriendButton = Utils.getElementBySelector(webDriver, By.xpath("//*[@id=\"secondary-header\"]/div/div[3]/button"));
            String buttonText = addFriendButton.getText();
            assertTrue(buttonText.contains("Отменить"));
        } catch (IllegalStateException ignored) {
        }

        webDriver.quit();
    }


    public static String generateString() {
        // Допустимые символы
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        // Длина строки
        int length = 8;
        // Строка для хранения сгенерированной последовательности
        StringBuilder stringBuilder = new StringBuilder();
        // Инициализируем генератор случайных чисел
        Random random = new Random();

        // Генерируем каждый символ строки
        for (int i = 0; i < length; i++) {
            // Выбираем случайный индекс из диапазона допустимых символов
            int randomIndex = random.nextInt(allowedChars.length());
            // Добавляем выбранный символ к строке
            stringBuilder.append(allowedChars.charAt(randomIndex));
        }

        // Возвращаем сгенерированную строку
        return stringBuilder.toString();
    }

}