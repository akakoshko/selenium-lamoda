package by.bsu.automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CatalogPage extends AbstractPage{
    private final String BASE_URL = "http://www.lamoda.by/c/15/shoes-women/?genders=women&sitelink=topmenuW&l=4";
    private final Logger logger = Logger.getLogger(MainPage.class);

    @FindBy(xpath = "//a[@href='/p/be062awhil53/shoes-bellacomoda-kedy-na-tanketke/']")
    private WebElement productHref;

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement productName;

    @FindBy(xpath = "//button[@class='product__cart-add-button button2 button2_l button2_blue']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[text()='Холодильник с морозильником ATLANT XM 4012-022']")
    private WebElement currentProduct;

    @FindBy(xpath = "//div[@class='ii-select__wrapper']")
    private WebElement chooseSize;

    @FindBy(xpath = "//div[text()='35 RUS']")
    private WebElement size;

    @FindBy(xpath = "//a[@class='ii-link user-navii__link user-navii__link_cart js-basket-button-title']")
    private WebElement cartButton;

    @FindBy(xpath = "//b[text()='Bella Comoda']")
    private WebElement productInCart;

    public CatalogPage(WebDriver driver)
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
    public void openProduct()
    {
        productHref.click();
        logger.info("Opened product page");
    }
    public String getProductInCart()
    {
        return productInCart.getText();
    }
    public void chooseSize()
    {
        chooseSize.click();
        size.click();
        logger.info("Size choose");
    }
    public void addToCart()
    {
        addToCartButton.click();
        logger.info("Added to cart");
    }
    public void goToCart()
    {
        cartButton.click();
        logger.info("Go to cart");
    }

}
