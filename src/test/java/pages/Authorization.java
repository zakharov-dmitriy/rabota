package pages;

import org.aspectj.apache.bcel.ExceptionConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Authorization extends Page{

    @FindBy(xpath = "//*[@id='laborer']//button[contains(@class, 'login-gosuslugi')]")
    public WebElement laborerEnterBtn;

    @FindBy(xpath = "//*[@id='employer']//button[contains(@class, 'login-gosuslugi')]")
    public WebElement employerEnterBtn;

    @FindBy(xpath = "//*[@data-target='#employer']")
    public WebElement employerTab;

    @FindBy(xpath = "//*[@data-target='#laborer']")
    public WebElement laborerTab;

    @FindBy(css = "#password")
    public WebElement inputPassword;

    public Authorization(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "/auth/login");
        PageFactory.initElements(driver, this);
    }

    EsiaLogin esia = new EsiaLogin(driver, wait);

    public void login(String login, String password) {
        laborerEnterBtn.click();
        esia.auth(login, password);
    }

    public void selectCandidate() {
        esia.accountSelectionAsCandidate();
    }

    public void selectEmployer() {
        esia.accountSelectionAsEmployer();
    }

    public void loginCandidate(String login, String password) {
        laborerEnterBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(inputPassword));
        esia.auth(login, password);
        esia.accountSelectionAsCandidate();
    }

    public void loginEmployer(String login, String password) {
        laborerEnterBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(inputPassword));
        esia.auth(login, password);
        esia.accountSelectionAsEmployer();
    }
}
