package by.bsu.automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewedPage extends AbstractPage {
    private final String BASE_URL = "https://www.21vek.by/viewed/";
    private final Logger logger = Logger.getLogger(MainPage.class);

    @FindBy(xpath = "//span[text()='Холодильник с морозильником ATLANT XM 4012-022']")
    private WebElement viewedProduct;

    public ViewedPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Opened login page");
    }
    public String getProduct(){
        return viewedProduct.getText();
    }
}
