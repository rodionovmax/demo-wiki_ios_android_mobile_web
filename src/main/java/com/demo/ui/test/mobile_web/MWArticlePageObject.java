package com.demo.ui.test.mobile_web;

import com.demo.ui.test.pageobjects.ArticlePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static
    {
        TITLE = By.cssSelector("#content h1");
//        OPTIONS_ADD_TO_MY_LIST_BUTTON = By.cssSelector("a#ca-watch");
        OPTIONS_ADD_TO_MY_LIST_BUTTON = By.cssSelector("a#ca-watch.mw-ui-icon-wikimedia-star-base20");
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = By.cssSelector("a#ca-watch.watched");
    }
}
