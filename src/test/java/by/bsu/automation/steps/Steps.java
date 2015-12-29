package by.bsu.automation.steps;

import java.util.concurrent.TimeUnit;

import by.bsu.automation.pages.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Steps
{
    private WebDriver driver;

    private final Logger logger = Logger.getLogger(Steps.class);

    private final String LOGOUT_CHECK = "Войти";

    public void initBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        logger.info("Initialized browser");
    }

    public void closeDriver()
    {
        driver.quit();
        logger.info("Stopped browser");
    }

    public void login(String email, String password)
    {
        MainPage loginPage = new MainPage(driver);
        loginPage.openPage();
        loginPage.login(email, password);
    }
    public boolean isLoggedIn(String username) {
        openNewTab();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.openPage();
        return (username.equals(dashboardPage.getLoggedInUserName()));
    }
    public boolean goProductPage(String product)
    {
        MainPage loginPage = new MainPage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openPage();
        loginPage.popUpClose();
        catalogPage.openProduct();
        catalogPage.chooseSize();
        catalogPage.addToCart();
        loginPage.popUpClose();
        catalogPage.goToCart();
        return (product.equals(catalogPage.getProductInCart()));
    }

    public boolean search(String search_subject,String search_result)
    {
        MainPage loginPage = new MainPage(driver);
        loginPage.openPage();
        loginPage.popUpClose();
        loginPage.search(search_subject);
        return (search_result.equals(loginPage.searchResult()));
    }
    public void logOut()
    {
        openNewTab();
        openNewTab();
        openNewTab();
        MainPage loginPage = new MainPage(driver);
        loginPage.openPage();
       // loginPage.popUpClose();
        loginPage.openProfileTab();
        loginPage.logOut();
    }
    public boolean logOutCheck()
    {
        MainPage loginPage = new MainPage(driver);
        loginPage.openPage();
        return (LOGOUT_CHECK.equals(loginPage.getLogInElemText()));
    }
    private void openNewTab() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        logger.info("Opened new tab");
    }
}
