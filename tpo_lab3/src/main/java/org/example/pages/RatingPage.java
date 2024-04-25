package org.example.pages;

import org.example.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RatingPage extends Page {
    public RatingPage(WebDriver driver) {
        super(driver);
    }

    public void skip() {
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"app-wrapper\"]/div[3]/div/div[2]/div/div/section/div/div[1]/div[7]/div[2]/div[1]/div[4]/div/button[2]")).click();
    }

    public void like() {
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"app-wrapper\"]/div[3]/div/div[2]/div/div/section/div/div[1]/div[7]/div[2]/div[1]/div[4]/div/button[3]")).click();
    }
}
