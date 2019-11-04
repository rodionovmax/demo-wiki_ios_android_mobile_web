package com.demo.ui.test.pageobjects;

import com.demo.ui.test.MainPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject {

    public AuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public static final By HAMBURGER_MENU = By.cssSelector("a[title='Open main menu']");
    public static final By LOGIN_BUTTON = By.xpath("//a[contains(text(),'Log in')]");
    public static final By LOGIN_INPUT = By.cssSelector("#wpName1");
    public static final By LOGIN_PASSWORD = By.cssSelector("#wpPassword1");
    public static final By SUBMIT_BUTTON = By.cssSelector("#wpLoginAttempt");


    public void clickAuthButton() {
//        waitForElementAndClick(HAMBURGER_MENU, 5);
        javaWaitInSec(1);
        waitForElementAndClick(LOGIN_BUTTON, 5);
    }

    public void enterLoginData(String username, String password) {
        // Enter login
        waitForElementAndClear(LOGIN_INPUT, 5);
        waitForElementAndSendKeys(LOGIN_INPUT, username, 5);
        // Enter password
        waitForElementAndClear(LOGIN_PASSWORD, 5);
        waitForElementAndSendKeys(LOGIN_PASSWORD, password, 5);
    }

    public void submitForm() {
        waitForElementAndClick(SUBMIT_BUTTON, 5);
    }
}
