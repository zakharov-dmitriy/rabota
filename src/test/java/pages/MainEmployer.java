package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainEmployer extends Page {
    private final JavascriptExecutor jsExecutor;

    @FindBy(css = ".content__title")
    public WebElement title;

    @FindBy(xpath = "//*[contains(@class, 'card') and contains(@class, 'mb-3')][1]//*//*[@data-action = 'submitApplication']")
    public WebElement declarationBtn;

    @FindBy(xpath = "//select[@name='company_formField']")
    public WebElement companyFormField;

    @FindBy(xpath = "//select[@name='company_address_regionField']")
    public WebElement regionField;
    @FindBy(xpath = "//*[@name='company_address_mainField']")
    public WebElement addressListbox;
    @FindBy(xpath = "//*[@name='company_address_mainField']/following-sibling::button")
    public WebElement addressFieldButton;
    @FindBy(xpath = "//*[contains(@class,'show')]//input[@class='bs-searchbox__input']")
    public WebElement fieldForInput;

    @FindBy(xpath = "//*[@name='company_address_houseField']")
    public WebElement companyAddressHouseField;

    @FindBy(xpath = "//*[@name='factAddressField']")
    public WebElement factAddressField;

    @FindBy(xpath = "//select[@name='czn_region_codeField']")
    public WebElement cznRegionSelect;

    @FindBy(xpath = "//select[@name='cznField']")
    public WebElement cznSelect;

    @FindBy(xpath = "//*[.='Добавить']")
    public WebElement infoEmployees;

    @FindBy(xpath = "//select[@name='needForEmployees@0@vacancyField']")
    public WebElement selectVacancy;

    @FindBy(xpath = "//button[.='Отправить заявление']")
    public WebElement sendButton;

    @FindBy(xpath = "//*[@infoblock-name='ICE Форма']//button[.='Посмотреть все заявления']")
    public WebElement checkBtn;

    @FindBy(xpath = "//*[@class='content__subtitle']")
    public WebElement titleSuccess;

    //для создания вакансии
    @FindBy(xpath = "//*[@class='group-container']/a")
    public WebElement newVacancy;

    @FindBy(xpath = "//*[@data-content='basic_information']//span[.='Название вакансии']/preceding-sibling::*/button")
    public WebElement nameVacancyField;
    @FindBy(xpath = "//*[@data-content='basic_information']//span[.='Профессия']/preceding-sibling::*/button")
    public WebElement nameOccupationField;

    @FindBy(xpath = "//*[@class='dropdown-menu show']//*[@class='bs-searchbox__input']")
    public WebElement nameSearchInput;

    @FindBy(xpath = "//*[@class='dropdown-menu show']//*[@class='no-results']")
    public WebElement nameVacancySearchNoResults;

    @FindBy(xpath = "//*[@class='dropdown-menu show']//*[@data-action='add-item']")
    public WebElement nameVacancyAddButton;

    @FindBy(xpath = "//*[@name='profession-name']")
    public WebElement professionNameSelect;

    @FindBy(xpath = "//*[@name='field-work']")
    public WebElement fieldWorkSelect;

    @FindBy(xpath = "//*[@name='cznType']")
    public WebElement typeVacancySelect;
    @FindBy(xpath = "//*[@name=\"czn\"]/option")
    public List<WebElement> options;
    @FindBy(xpath = "//*[@name=\"czn\"]/following-sibling::button")
    public WebElement cznFieldBtn;
    @FindBy(xpath = "//*[@name='czn']")
    public WebElement czn;

    @FindBy(xpath = "//*[@id='positionResponsibilities_ifr']")
    public WebElement responsibilitiesFrame;
    @FindBy(xpath = "//*[@id='positionRequirements_ifr']")
    public WebElement requirementsFrame;
    @FindBy(xpath = "//*[@data-id='positionResponsibilities']/p")
    public WebElement responsibilitiesElement;
    @FindBy(xpath = "//*[@data-id='positionRequirements']/p")
    public WebElement requirementsElement;

    @FindBy(xpath = "//*[@name='contactPerson']")
    public WebElement contactPersonInput;
    @FindBy(xpath = "//*[@name='phone']")
    public WebElement phone;
    @FindBy(xpath = "//*[@data-action='publish']")
    public WebElement publishButton;

    @FindBy(xpath = "//*[@class='modal modal_open']")
    public WebElement modal;
    @FindBy(xpath = "//*[@data-action='cancel']")
    public WebElement cancelBtnModal;


    @FindBy(css = "[name='form-esia-complete-registration']")
    public WebElement formRegistration;

    @FindBy(xpath = "//*[@value='joinCommon']")
    public WebElement formRadioJoin;

    @FindBy(xpath = "//*[@value='OWNER']")
    public WebElement formRoleOwner;

    @FindBy(xpath = "//*[@value='ADMINISTRATOR']")
    public WebElement formRoleAdministrator;

    @FindBy(css = "[data-action='register']")
    public WebElement formButton;

    public MainEmployer(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "/auth/manager");
        PageFactory.initElements(driver, this);
        jsExecutor = (JavascriptExecutor) driver;
    }

    public String getTitle() {
        return title.getText();
    }

    public void setCompanyFormField() {
        new Select(companyFormField).selectByVisibleText("Непубличные акционерные общества");
    }

    public void setRegion() throws InterruptedException {
        new Select(regionField).selectByVisibleText("г Санкт-Петербург");
        Thread.sleep(1000);
    }

    public void setAddress() {
        jsExecutor.executeScript("arguments[0].click()", addressFieldButton);
        fieldForInput.sendKeys("г Санкт-Петербург, пр-кт Приморский");
        new Select(addressListbox).selectByVisibleText("г Санкт-Петербург, пр-кт Приморский");
    }

    public void setCznRegionSelect() {
        new Select(cznRegionSelect).selectByVisibleText("г Санкт-Петербург");
    }

    public void setCznSelect() throws InterruptedException {
        Thread.sleep(1000);
        new Select(cznSelect).selectByVisibleText("СПб ГАУ ЦЗН АЗН Приморского района СПб");
    }

    public void infoEmployeesClick() {
        try {
            infoEmployees.click();
        } catch (ElementClickInterceptedException e) {
            jsExecutor.executeScript("arguments[0].click(true)", infoEmployees);
        }
    }

    public void setSelectVacancy() {
        new Select(selectVacancy).selectByValue("7c398188-92c9-11ef-819c-d770ac669473");
    }

    public void sendButtonClick() {
        clickElement(sendButton);
    }

    //Добавление вакансии
    public String getTitleSuccess() {
        wait.until(ExpectedConditions.visibilityOf(titleSuccess));
        return titleSuccess.getText();
    }

    public void setVacancy(String name) {
        nameVacancyField.click();
        nameSearchInput.sendKeys(name);
//        nameVacancySearchNoResults
        nameVacancyAddButton.click();
    }

    public void setOccupation(String name) {
        nameOccupationField.click();
        nameSearchInput.sendKeys(name);
        new Select(professionNameSelect).selectByVisibleText(name);
    }

    public void setFieldWork() {
        new Select(fieldWorkSelect).selectByValue("NotQualification");
    }

    public void setTypeVacancy(String name) {
        new Select(typeVacancySelect).selectByVisibleText(name);
    }

    public void setCzn() {
        if (czn.getAttribute("disabled") != null && czn.getAttribute("disabled").equals("disabled")) {
            System.out.println("Элемент заблокирован и не доступен для выбора");
        } else {
//            jsExecutor.executeScript("arguments[0].click(true)", cznFieldBtn);
            wait.withTimeout(Duration.ofSeconds(15)).until(ExpectedConditions.
                    presenceOfAllElementsLocatedBy(By.xpath("//*[@name=\"czn\"]/option")));
            new Select(czn).selectByVisibleText("\"Внуково\"");
        }
    }

    public void inputResponsibilities(String text) {
        driver.switchTo().frame(responsibilitiesFrame);
        responsibilitiesElement.sendKeys(text);
        driver.switchTo().defaultContent();
    }

    public void inputRequirements(String text) {
        driver.switchTo().frame(requirementsFrame);
        requirementsElement.sendKeys(text);
        driver.switchTo().defaultContent();
    }

    public void publishButtonClick() {
        jsExecutor.executeScript("arguments[0].click(true)", publishButton);
        if (modal.isDisplayed()) {
            cancelBtnModal.click();
        driver.switchTo().alert().accept();
        }
    }

    public String getTitleText() {
        wait.withTimeout(Duration.ofSeconds(45)).until(ExpectedConditions.textToBePresentInElement(title,
                "Вакансии компании"));
        return title.getText();
    }

    //метод для присоедниения к компании и выбора роли
    public void choiseRole() {
        if (!formRegistration.isDisplayed()) {
            clickElement(header.megaMenu);
        } else {
//            header.megaMenu.click();
            clickElement(formRadioJoin);
            clickElement(formRoleOwner);
            clickElement(formButton);
        }
    }

    //универсальный метод клика по элементу
    private void clickElement(WebElement element) {
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            jsExecutor.executeScript("arguments[0].click(true)", element);
        }
    }
}
