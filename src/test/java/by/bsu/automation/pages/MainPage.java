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

public class MainPage extends AbstractPage
{
    private final String BASE_URL = "http://www.lamoda.by";
    private final Logger logger = Logger.getLogger(MainPage.class);

    @FindBy(xpath = "//span[@class='popup__close']")
    private WebElement popUpClose;

    @FindBy(xpath = "//span[@class='ii-link user-navii__link js-auth-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder='E-mail']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@class='button2 button2_blue']")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@class='text-field2 searchii__input js-search-field']")
    private WebElement searchTextArea;

    @FindBy(xpath = "//span[@class='breadcrumbs__item-link']")
    private WebElement searchResult;

    @FindBy(xpath = "//span[@class='button-dropdown js-user-nav']")
    private WebElement userNavButton;

    @FindBy(xpath = "//a[text()='Выйти']")
    private WebElement logoutButton;

    public MainPage(WebDriver driver)
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

    public void login(String email, String password)
    {
        popUpClose.click();
        loginButton.click();
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        submitButton.click();
        logger.info("Logged in");
    }
    public void popUpClose()
    {
        popUpClose.click();
    }
    public void search(String string){
        searchTextArea.click();
        driver.switchTo().activeElement().sendKeys(string);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='js-suggest-list searchii__suggest-list suggest2__list']")));
        driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        logger.info("Used search");
    }
    public String searchResult(){
        return searchResult.getText();
    }
    public void openProfileTab()
    {
        userNavButton.click();
        logger.info("Opened users nav panel");
    }
    public void logOut()
    {
        logoutButton.click();
        logger.info("Logout");
    }
    public String getLogInElemText()
    {
        return loginButton.getText();
    }

}