package org.example.uc;

import org.example.Utils;
import org.example.pages.SearchPage;
import org.example.pages.StartPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class SearchTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }
    @Test
    void starFirst() {
        WebDriver webDriver = Utils.getDriver();

        StartPage startPage = new StartPage(webDriver);

        webDriver.get(Utils.BASE_URL);

        startPage.doLogin();

        SearchPage searchPage = new SearchPage(webDriver);
        webDriver.get(Utils.SEARCH_PAGE);

        searchPage.starFirst();

        webDriver.quit();
    }
}
