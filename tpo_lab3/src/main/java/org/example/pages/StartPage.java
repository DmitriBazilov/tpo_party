package org.example.pages;

import org.example.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class StartPage extends Page {

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public void doRegister() {
        tryRegister("аркадий", "testaye123231@mail.com");

    }

    public void doLogout() {
        WebElement suggestionButton = Utils.getElementBySelector(driver, By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[1]/button"));
        suggestionButton.click();
        WebElement profilePicButton = Utils.getElementBySelector(driver, By.xpath("//*[@id=\"app-wrapper\"]/div[1]/header/div[6]/a[1]"));
        profilePicButton.click();
        WebElement settingsButton = Utils.getElementBySelector(driver, By.xpath("//*[@id=\"app-wrapper\"]/div[3]/div/div[2]/div/section/nav/div[3]/div/a"));
        settingsButton.click();
        WebElement logout = Utils.getElementBySelector(driver, By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/main/a"));
        logout.click();
        WebElement confirm = Utils.getElementBySelector(driver, By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div/div/div/main/div/div[2]/button"));
        confirm.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
    }

    private void tryRegister(CharSequence name, CharSequence mail) {
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/div[1]/div/div[1]/button")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/div[4]/div/button")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/div[3]/div/button")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/div[4]/div/button")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/form/div[1]/div/input"))
                .sendKeys(name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/form/div[3]/div/input")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }

        WebElement selectElement = Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/form/div[2]/div/div[1]/label/select"));
        Select select = new Select(selectElement);
        select.selectByValue("1");

        WebElement selectElement2 = Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/form/div[2]/div/div[2]/label/select"));
        Select select2 = new Select(selectElement2);
        select2.selectByValue("1");

        WebElement selectElement3 = Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/form/div[2]/div/div[3]/label/select"));
        Select select3 = new Select(selectElement3);
        select3.selectByValue("2000");

        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/form/div[4]/div/input")).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }

        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/form/div[1]/div/input"))
                .sendKeys(mail);

        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/form/div[2]/div/button")).click();
    }

    public void doLogin() {

        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/div[1]/header/div/a")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[4]/div/div/div/div/a[1]")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }

        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[4]/div/div/div/main/form/div[1]/div/input"))
                .sendKeys("mytsstepan@gmail.com");
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[4]/div/div/div/main/form/div[2]/div/div/input"))
                .sendKeys("TjFZ9xtV");
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[4]/div/div/div/main/form/div[4]/input")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }


    }

}
