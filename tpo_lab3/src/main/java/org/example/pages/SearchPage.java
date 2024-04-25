package org.example.pages;

import org.example.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends Page {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void starFirst() {
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"app-wrapper\"]/div[3]/div/div[2]/section/div/div/div/div[2]/div[1]/a")).click();
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[1]/button")).click();
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"app-wrapper\"]/div[3]/div/div[2]/div/section/div[1]/div[2]/div[1]/div[2]/span[2]/div[2]")).click();
    }
}
