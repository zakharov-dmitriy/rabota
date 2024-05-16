package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EsiaLogin extends Page{

    @FindBy(css = "#login")
    public WebElement inputLogin;

    @FindBy(css = "#password")
    public WebElement inputPassword;

    @FindBy(xpath = "//*[contains(@class, 'plain-button_wide')]")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[contains(@class, 'unq-auth-button')][1]")
    public WebElement publicPerson;

    @FindBy(xpath = "//*[contains(@class, 'unq-auth-button')][2]")
    public WebElement soleProprietor;

    public EsiaLogin(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void auth(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        loginBtn.click();
    }

    public void accountSelectionAsCandidate() {
        publicPerson.click();
    }

    public void accountSelectionAsEmployer() {
        soleProprietor.click();
    }
}
