package com.demo.ui.test.mobile_web;

import com.demo.ui.test.pageobjects.SearchPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MWSearchPageObject extends SearchPageObject {

    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static
    {
        SEARCH_INIT_ELEMENT = By.cssSelector("button#searchIcon");
        SEARCH_INPUT = By.cssSelector("form>input[name='search']");
        SEARCH_RESULT_BY_SUBSTRING_TPL = "//div[@class='wikidata-description'][contains(text(), '{SUBSTRING}')]";
    }
}
