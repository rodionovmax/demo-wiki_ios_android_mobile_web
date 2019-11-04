package com.demo.ui.test.mobile_web;

import com.demo.ui.test.pageobjects.NavigationUI;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {

    static {
        MY_LISTS_LINK = By.cssSelector("a[data-event-name='menu.watchlist']");
        HAMBURGER_MENU = By.cssSelector("#mw-mf-main-menu-button");
    }

    public MWNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
