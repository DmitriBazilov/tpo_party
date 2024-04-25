package org.example.pages;

import org.example.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void doRegister() {
//        tryLogin(Utils.CORRECT_FIRST_USER_LOGIN, Utils.CORRECT_FIRST_USER_PASSWORD);
        tryRegister("аркадий", "testaye123231@mail.com");

    }

    public void doSecondUserLogin() {
        tryLogin(Utils.CORRECT_SECOND_USER_LOGIN, Utils.CORRECT_SECOND_USER_PASSWORD);
    }

    public void doWrongLogin() {
        tryLogin(Utils.CORRECT_FIRST_USER_LOGIN, Utils.WRONG_FIRST_USER_PASSWORD);
    }

    public void doLogout() {
        WebElement burgerMenuButton = Utils.getElementBySelector(driver, By.xpath("//*[@id=\"header-profile-tooltip\"]/button"));
        burgerMenuButton.click();
        WebElement logoutButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[3]/div/div/div/a[13]"));
        logoutButton.click();
        WebElement confirmLogoutButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[3]/div/div/div/div/button"));
        confirmLogoutButton.click();
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException ignored){}
    }

    private void tryRegister(CharSequence name, CharSequence mail) {
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/div[1]/div/div[1]/button")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored){}
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/div[4]/div/button")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored){}
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/div[3]/div/button")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored){}
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/div[4]/div/button")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored){}
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/form/div[1]/div/input"))
                .sendKeys(name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored){}
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/form/div[3]/div/input")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored){}

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
        } catch (InterruptedException ignored){}

        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/form/div[1]/div/input"))
                .sendKeys(mail);


        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/form/div[2]/div/button")).click();






    }

    private void tryLogin(CharSequence login, CharSequence password) {
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/div[1]/header/div/a")).click();
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[4]/div/div/div/div/a[1]")).click();
        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[4]/div/div/div/main/form/div[1]/div/input"))
                .sendKeys(login);

        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[4]/div/div/div/main/form/div[2]/div/div/input"))
                .sendKeys(password);

        Utils.getElementBySelector(driver, By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[4]/div/div/div/main/form/div[4]/input")).click();
//        WebElement loginButton = Utils.getElementBySelector(driver, By.xpath("//*[@id=\"header\"]/div/div/div/div/div[4]/ul/li[2]/button"));
//        loginButton.click();
//        WebElement loginByEmailButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[3]/div/div/div/div/div/form/div[6]/button"));
//        loginByEmailButton.click();
//        WebElement loginInput = Utils.getElementBySelector(driver, By.xpath("//*[@id=\"authFormLoginByEmailEmail\"]"));
//        WebElement loginPassword = Utils.getElementBySelector(driver, By.xpath("//*[@id=\"authFormLoginByEmailPassword\"]"));
//        WebElement authButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[3]/div/div/div/div/div/form/div[3]/button"));
//        loginInput.clear();
//        loginPassword.clear();
//        loginInput.sendKeys(login);
//        loginPassword.sendKeys(password);
//        authButton.click();
//        try{
//            Thread.sleep(3000);
//        }
//        catch (InterruptedException ignored){}
    }
}
