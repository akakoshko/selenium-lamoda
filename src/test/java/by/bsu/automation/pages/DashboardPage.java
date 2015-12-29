package by.bsu.automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends AbstractPage
{
    private final String BASE_URL = "https://www.lamoda.by/customer/account/edit/";
    private final Logger logger = Logger.getLogger(DashboardPage.class);

    @FindBy(xpath = "//input[@name='email']")
    private WebElement username;

    public DashboardPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Opened dashboard page");
    }

    public String getLoggedInUserName()
    {
        return username.getAttribute("value");
    }
}