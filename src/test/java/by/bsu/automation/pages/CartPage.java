package by.bsu.automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractPage{
    private final String BASE_URL = "https://www.21vek.by/order/";
    private final Logger logger = Logger.getLogger(MainPage.class);

    @FindBy(xpath = "//td[@class='g-table-cell basket__item cr-basket__name']/a")
    private WebElement productName;

    public CartPage(WebDriver driver)
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
    public String getProductName()
    {
        return productName.getText();
    }
}
