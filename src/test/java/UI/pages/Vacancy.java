package UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vacancy extends Page {

    public Vacancy(WebDriver driver, WebDriverWait wait) {
        super(driver, wait,"vacancy/");
    }
}
