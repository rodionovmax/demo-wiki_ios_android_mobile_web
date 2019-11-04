package com.demo.ui.test.tests;

import com.demo.ui.test.CoreTestCase;
import com.demo.ui.test.DeviceCapabilities;
import com.demo.ui.test.factories.ArticlePageObjectFactory;
import com.demo.ui.test.factories.MyListsPageObjectFactory;
import com.demo.ui.test.factories.NavigationUIFactory;
import com.demo.ui.test.factories.SearchPageObjectFactory;
import com.demo.ui.test.pageobjects.*;
import org.testng.annotations.Test;

import static com.demo.ui.test.DeviceCapabilities.devicePlatform;

public class MyListTests extends CoreTestCase {

//    private static final String search_input = "Java";
    private static final String search_input = "Asics";
//    private static final String article_results_substring = "Java (programming language)";
    private static final String article_results_substring = "Japanese athletic equipment company";
//    private static final String article_results_substring = "Asics";
    private static final String name_of_folder = "Read later";
    private static final String username = "rodionovmax90";
    private static final String password = "gmiv0ak4";

    @Test
    public void saveArticleToMyListAndDelete() {

        // If Platform is iOS and Enable Syncing popup appears - enable it
        if (devicePlatform.equals(DeviceCapabilities.DevicePlatform.IOS)) {
            if (articlePage.isEnableSyncingPopupAppears()) {
                articlePage.clickEnableSyncing();
            }
        }

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_input);
        SearchPageObject.clickOnTheArticleWithSubstring(article_results_substring);

        /*
        String title_actual = articlePage.waitForTitleOfArticle(article_results_substring).getText();
//        String title_expected = "Java (programming language)";
        String title_expected = "Asics";
        Assert.assertEquals(title_actual, title_expected, "Actual title doesn't match with expected.");

        System.out.println("Assert passed. Actual and expected titles match");
         */

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if (devicePlatform.equals(DeviceCapabilities.DevicePlatform.ANDROID)) {
            System.out.println("Platform was identified as: " + devicePlatform);
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            System.out.println("Platform was identified as: " + devicePlatform);
            ArticlePageObject.addArticlesToMySaved();
        }
        if (devicePlatform.equals(DeviceCapabilities.DevicePlatform.MOBILE_WEB)) {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(username, password);
            Auth.submitForm();

            ArticlePageObject.addArticlesToMySaved();
        }

        if (devicePlatform.equals(DeviceCapabilities.DevicePlatform.IOS)) {
            if (ArticlePageObject.isLoginToSyncPopupAppears()) {
                ArticlePageObject.loginToSyncSavedArticles(username, password);
            }
            if (ArticlePageObject.isEnableSyncingPopupAppears()) {
                ArticlePageObject.clickEnableSyncing();
            }
            if (ArticlePageObject.isSavedArticlesFoundPopupAppears()) {
                ArticlePageObject.clickAddArticlesToReadingList();
            }
        }


        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.openNavigation();
        NavigationUI.ClickMyList();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

        if(devicePlatform.equals(DeviceCapabilities.DevicePlatform.ANDROID)){
            MyListsPageObject.openFolderByName(name_of_folder);
        }
//        MyListsPageObject.swipeByArticleToDelete(article_results_substring);
        MyListsPageObject.swipeByArticleToDelete(article_title);

        if(devicePlatform.equals(DeviceCapabilities.DevicePlatform.ANDROID)){
            MyListsPageObject.deleteArticlesFolder();
        }
    }

    @Test
    public void findHowToUsePlatformVars() {

        if (devicePlatform.equals(DeviceCapabilities.DevicePlatform.IOS)) {
            System.out.println("This is iPhone simulator");
        } else if (devicePlatform.equals(DeviceCapabilities.DevicePlatform.ANDROID)) {
            System.out.println("This is Android emulator");
        } else {
            System.out.println("This is Mobile Web");
        }

//        MyListsPageObject MyListsPageObject = new MyListsPageObjectFactory(driver);

//        myLists.myListForAndroid();
    }
}
