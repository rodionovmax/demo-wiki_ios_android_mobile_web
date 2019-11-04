package com.demo.ui.test.pageobjects;

import com.demo.ui.test.DeviceCapabilities;
import com.demo.ui.test.MainPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.demo.ui.test.DeviceCapabilities.devicePlatform;

public class NavigationUI extends MainPageObject {

    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    public static By MY_LISTS_LINK;
    public static By HAMBURGER_MENU;

    public void openNavigation() {
        if (devicePlatform.equals(DeviceCapabilities.DevicePlatform.MOBILE_WEB)) {
            javaWaitInSec(1);
            waitForElementAndClick(HAMBURGER_MENU, 5);
        }
    }

    public void ClickMyList() {
        if (devicePlatform.equals(DeviceCapabilities.DevicePlatform.MOBILE_WEB)) {
            tryClickElementWithFewAttempts(MY_LISTS_LINK, 5);
        } else {
            waitForElementAndClick(MY_LISTS_LINK, 5);
        }
//        waitForElementAndClick(MY_LISTS_LINK, 5);
    }
}
