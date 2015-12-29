package by.bsu.automation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.bsu.automation.steps.Steps;

public class TwentyFirstCenturyAutomationTest {
    private Steps steps;
    private final String EMAIL = "akaynt100@tut.by";
    private final String PASSWORD = "testepam1";
    private final String PRODUCT = "Bella Comoda";
    private final String CURRENT_PRODUCT = "Холодильник с морозильником ATLANT XM 4012-022";
    private final String SEARCH_SUBJECT = "кеды converse";
    private final String SEARCH_RESULT = "Поиск по запросу «кеды converse»";

    @BeforeMethod (description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }
    @Test (description = "Login")
    public void oneCanLogin() {
        steps.login(EMAIL,PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(EMAIL));
    }
    @Test (description = "Check chosen product in cart")
    public void oneCanAddToCart(){
        Assert.assertTrue(steps.goProductPage(PRODUCT));
    }
    @Test (description = "Check search")
    public void oneCanCheckSearch(){
        Assert.assertTrue(steps.search(SEARCH_SUBJECT,SEARCH_RESULT));
    }
    @Test (description = "Logout")
    public void oneCanCheckLogOut(){
        steps.login(EMAIL,PASSWORD);
        steps.logOut();
        Assert.assertTrue(steps.logOutCheck());
    }
    @AfterMethod (description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}