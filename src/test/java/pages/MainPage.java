package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage extends Page {

    private final JavascriptExecutor jsExecutor;
//    private final String url = "https://trudvsem.ru";

    @FindBy(xpath = "//*[@class = 'choose-region__tooltip']//button[.='Да']")
    public WebElement region;

    @FindBy(xpath = "//*[@class = 'cookies']//button")
    public WebElement acceptCookie;

    @FindBy(xpath = "//*[@class='  col-md-12   ']//*[@class ='main__search']//*[@class='content__title']")
    public WebElement titleEmployees;

    @FindBy(css = ".home__search-control")
    private WebElement searchInput;

    @FindBy(css = ".home__search-button")
    private WebElement searchButton;

    @FindBy(css = "a.tabs__item")
    private WebElement tabEmployer;

    @FindBy(xpath = "//*[@class='main__search']//*[@class='content__title']")
    public WebElement searchVacancy;

    @FindBy(xpath = "//*[contains(@class,'search-layout')]//*[@class='content__title']")
    public WebElement searchCV;

    @FindBy(xpath = "//*[@class= 'main__search-content main__search-content_active']")
    public WebElement searchContent;

    @FindBy(xpath = "//*[@infoblock-name='Работа для всех']//*[contains(@class, 'card_flexible')]")
    public List<WebElement> cardBtn;

    public String messageInCaseOfFailedTest = "Неверная страница";

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        jsExecutor = (JavascriptExecutor) driver;
    }

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "");
        PageFactory.initElements(driver, this);
        jsExecutor = (JavascriptExecutor) driver;
    }

//    public void acceptCookiesAndRegion() {
//        region.click();
//        acceptCookie.click();
//    }

    public String getTitle() {
        return title.getText();
    }

    public void clickOnTab() {
        tabEmployer.click();
    }

    public void fillFieldSearch(String text) {
        searchInput.sendKeys(text);
    }

    public void searchVacancy(String text) {
        searchInput.sendKeys(text);
        searchButton.click();
    }

    public boolean titleContainsText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(titleEmployees, "Вакансии на должность"));
        return wait.until(driver -> titleEmployees.getText().contains(text));
    }

    public String checkTitle(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(searchContent));
        return element.getText();
    }

    public void clickOnCard() {
//        for (WebElement webElement : cardBtn) {
//            jsExecutor.executeScript("arguments[0].click(true)", cardBtn.get(0));
//        }
        jsExecutor.executeScript("arguments[0].click(true)", cardBtn.get(0));
    }

}
