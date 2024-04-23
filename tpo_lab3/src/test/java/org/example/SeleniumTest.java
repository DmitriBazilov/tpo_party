package org.example;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class SeleniumTest {

    @BeforeAll
    static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    void testDriver() {
        executeWithCapabilities(Utils.getDriver());
    }

    @SneakyThrows
    private void executeWithCapabilities(WebDriver driver) {
        driver.get(Utils.BASE_URL);
        Thread.sleep(1000);
        String title = driver.getTitle();
        assertEquals("Бесплатный сайт знакомств - регистрация | Мамба", title);
        driver.quit();
    }
}