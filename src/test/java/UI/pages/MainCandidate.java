package UI.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainCandidate extends Page {

    private final JavascriptExecutor jsExecutor;

    @FindBy(css = ".content__title")
    public WebElement title;

    @FindBy(xpath = "//*[@class='group-container']/a")
    public WebElement newResume;

    @FindBy(xpath = "//*[@name='positionName']")
    public WebElement desiredPosition;

    @FindBy(id = "professionSphereId")
    public WebElement selectSphere;

    @FindBy(xpath = "//*[@value='Medicine']")
    public WebElement field;

    @FindBy(xpath = "//*[@name='salary']")
    public WebElement salary;

    @FindBy(xpath = "//*[@name='switch_work_experience']")
    public WebElement switchWorkExperience;

    @FindBy(xpath = "//button[@value='publish']")
    public WebElement publishBtn;

    @FindBy(css = "[data-content=card_review]")
    public WebElement cardForWait;

    @FindBy(xpath = "//*[@data-content='card_review']//*[contains(@class,'card')][10]//a")
    public WebElement titleMiniCard;

    @FindBy(xpath = "//*[@data-content='card_review']//*[@class='content__section-title']//a")
    public List<WebElement> titleCard;

    @FindBy(xpath = "//*[@data-content='card_review']//*[contains(@class,'card')]//*[@class='date-preview']")
    public List<WebElement> dateCard;

    @FindBy(xpath = "//*[@data-content='card_review']//*[contains(@class,'card') and not (contains(@class,'card__'))]")
    public List<WebElement> card;


    @FindBy(xpath = "//*[@class='pagination']")
    public WebElement paginationBox;

    @FindBy(xpath = "//*[@class='pagination']//*[contains(@class, 'pagination__item') and " +
            "not(contains(@class, 'pagination__item_previous')) and not(contains(@class, 'pagination__item_next'))]")
    public List<WebElement> paginationList;

    @FindBy(xpath = "//*[@class='pagination']//*[@aria-label='Следующая']")
    public WebElement paginationNext;


    //СЗН
    @FindBy(xpath = "//*[@class = 'mega-menu__toggle']")
    public WebElement megaMenu;

    @FindBy(xpath = "//*[.= 'Все услуги']")
    public WebElement allServices;

    @FindBy(xpath = "//*[contains(@class, 'card') and contains(@class, 'mb-3')][1]//*//*[@data-action = 'submitApplication']")
    public WebElement declarationBtn;

    @FindBy(xpath = "//*[contains(@alt, 'вы можете быть признанным безработным')]")
    public WebElement radioClaim;

    @FindBy(xpath = "//select[@name='id_cvField']")
    public WebElement cvSelect;

    @FindBy(xpath = "//select[@name='regionField']")
    public WebElement regionSelect;

    //регион и адрес
    @FindBy(xpath = "//button[@title='Выберите регион']")
    public WebElement regionField;
    @FindBy(tagName = "regionField")
    public WebElement regionSelect1;
    @FindBy(xpath = "//*[@class='dropdown-item active']")
    public WebElement regionValue;


    @FindBy(xpath = "//*[@name='addressField']")
    public WebElement addressSelect;

    @FindBy(xpath = "//*[@name='addressField']/../*[@aria-haspopup='listbox']")
    public WebElement addressListbox;

    @FindBy(xpath = "//*[contains(@class,'show')]//*[@class='bs-searchbox__input']")
    public WebElement fieldForInput;

    @FindBy(xpath = "//select[@name='addressField']")
    public WebElement selectAddress;

    @FindBy(xpath = "//*[@name='client_address_houseField']")
    public WebElement clientAddressHouse;

    @FindBy(xpath = "//select[@name='czn_region_codeField']")
    public WebElement cznRegionSelect;

    @FindBy(xpath = "//select[@name='cznField']")
    public WebElement cznSelect;

    @FindBy(xpath = "//*[@value='MIR']")
    public WebElement switchBenefit;

    @FindBy(xpath = "//*[@name='mirNumberField']")
    public WebElement mirNumberField;

    //Не достигшие 16-летнего возраста
    @FindBy(xpath = "//input[@name='underAgeOf16Field' and @value = 'NO']")
    public WebElement underAgeOf16Radio;

    //Получающие пенсию по старости или за выслугу лет
    @FindBy(xpath = "//input[@name='recipientsOldAgeOrSeniorityPensionsField' and @value = 'NO']")
    public WebElement recipientsOldAgeRadio;

    //Осужденные по решению суда к исправительным работам
    @FindBy(xpath = "//input[@name='convictedField' and @value = 'NO']")
    public WebElement convictedRadio;

    //Выполняющие оплачиваемую работу
    @FindBy(xpath = "//input[@name='havePayingJobField' and @value = 'NO']")
    public WebElement havePayingJobRadio;

    //Индивидуальные предприниматели, нотариусы, адвокаты
    @FindBy(xpath = "//input[@name='notariesLawyersIPField' and @value = 'NO']")
    public WebElement notariesLawyersIPRadio;

    //Занятые в подсобных промыслах и реализующих продукцию по договорам
    @FindBy(xpath = "//input[@name='sellingProductsUnderContractsField' and @value = 'NO']")
    public WebElement sellingProductsUnderContractsRadio;

    //Выполняющие работы по договорам
    @FindBy(xpath = "//input[@name='contractWorkField' and @value = 'NO']")
    public WebElement contractWorkRadio;

    //Избранные, назначенные или утвержденные на оплачиваемую должность
    @FindBy(xpath = "//input[@name='selectedForPaidPositionField' and @value = 'NO']")
    public WebElement selectedForPaidPositionRadio;

    //Проходящие военную или альтернативную гражданскую службу
    @FindBy(xpath = "//input[@name='militaryServiceField' and @value = 'NO']")
    public WebElement militaryServiceRadio;

    //Обучающиеся по очной форме обучения
    @FindBy(xpath = "//input[@name='fullTimeStudentsField' and @value = 'NO']")
    public WebElement fullTimeStudentsRadio;

    //Временно отсутствующие на рабочем месте
    @FindBy(xpath = "//input[@name='temporarilyAbsentFromWorkplaceField' and @value = 'NO']")
    public WebElement temporarilyAbsentFromWorkplaceRadio;

    //Учредители организаций
    @FindBy(xpath = "//input[@name='foundersField' and @value = 'NO']")
    public WebElement foundersRadio;

    //Являющиеся членами крестьянского (фермерского) хозяйства
    @FindBy(xpath = "//input[@name='membersOfPeasantFarmField' and @value = 'NO']")
    public WebElement membersOfPeasantFarmRadio;

    //Осуществляющие уход за инвалидом
    @FindBy(xpath = "//input[@name='disabledPersonCareField' and @value = 'NO']")
    public WebElement disabledPersonCareField;

    //Приемные родители
    @FindBy(xpath = "//input[@name='adoptiveParentsField' and @value = 'NO']")
    public WebElement adoptiveParentsField;

    //Являющиеся плательщиками налога на профессиональный доход
    @FindBy(xpath = "//input[@name='professionalIncomeTaxPayersField' and @value = 'NO']")
    public WebElement professionalIncomeTaxPayersRadio;

    @FindBy(xpath = "//input[@name='familiarizedWithLawField']")
    public WebElement familiarizedWithLawCheckbox;

    @FindBy(xpath = "//input[@name='warningFalseDataField']")
    public WebElement warningFalseDataCheckbox;

    @FindBy(xpath = "//input[@name='consentPersonalDataField']")
    public WebElement consentPersonalDataCheckbox;

    @FindBy(xpath = "//input[@name='personalDataThirdPartiesField']")
    public WebElement personalDataThirdPartiesCheckbox;

    @FindBy(xpath = "//input[@name='refusalFalseInformationField']")
    public WebElement refusalFalseInformationCheckbox;

    @FindBy(xpath = "//input[@name='fraudulentBenefitField']")
    public WebElement fraudulentBenefitCheckbox;

    @FindBy(xpath = "//*[@data-action='sendApplication']")
    public WebElement sendApplication;

    @FindBy(xpath = "//*[@class='content__subtitle']")
    public WebElement titleSuccess;

    @FindBy(xpath = "//*[@infoblock-name='ICE Форма']//button[.='Посмотреть все заявления']")
    public WebElement checkBtn;


    public MainCandidate(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "/auth/candidate");
        PageFactory.initElements(driver, this);
        jsExecutor = (JavascriptExecutor) driver;
    }

    public String getTitle() {
        return title.getText();
    }

    public String getTextFieldValue() {
        return field.getText();
    }

    public void setField() {
        var profSphere = new Select(selectSphere);
        profSphere.selectByVisibleText(getTextFieldValue());
    }

    public void getField() {
        var profSphere = new Select(selectSphere);
        profSphere.getFirstSelectedOption().getText();
    }

    //Несколько методов прокрутки к элементу
    /*public void scrollToElement() throws InterruptedException {
        new Actions(driver).moveToElement(publishBtn).perform();
        form.sendKeys(Keys.END);

        //проскролить до элемента пока он не станет видимым
        //jsExecutor.executeScript("arguments[0].scrollIntoView(true);", publishBtn);
        //wait.until(ExpectedConditions.elementToBeClickable(publishBtn));

        //проскролить до элемента и сместиться на 50 пикселей
        //jsExecutor.executeScript("arguments[0].scrollIntoView();", publishBtn);
        //jsExecutor.executeScript("window.scrollBy(0, 50);");
    }*/

    public void publishBtnClick() {
        try {
            publishBtn.click();
        } catch (ElementClickInterceptedException e) {
            jsExecutor.executeScript("arguments[0].click()", publishBtn);
        }
    }

    public String getExpectedUrl() {
        wait.until(ExpectedConditions.visibilityOfAllElements(cardForWait));
        Page page = new Page(driver, wait);
        return page.getPageUrl() + "/auth/candidate/cvs";
    }

    //метод с поиском карточки без блока с пагинацией
    /*public boolean checkingTheCardOnThePage(String name) {
        for (int i = 0; i < card.size(); i++) {
            var title = titleCard.get(i).getText();
            var date = dateCard.get(i).getText();
            if (title.equals(name) && date.contains("Сегодня")){
                return true;
            }
        }
        return false;
    }*/

    //******
    public void testSwitchPage() {
        if (paginationNext.isDisplayed()) { /*не работает если есть условный оператор*/
            try {
                paginationNext.click();
            } catch (ElementClickInterceptedException e) {
                jsExecutor.executeScript("arguments[0].click(true)", paginationNext);
            }
        } else {
            System.out.println("Нет клика, что-то пошло не так, разбирайся!");
        }
    }

    //метод с переключением на следующую страницу
    /*public boolean checkingTheCardOnThePage(String name) {
        for (int i = 0; i < card.size(); i++) {
            var title = titleCard.get(i).getText();
            var date = dateCard.get(i).getText();
            if (title.equals(name) && date.contains("Сегодня")) {
                return true;
            }
        }

        while (paginationBox.isDisplayed()) {
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
            try {
                paginationNext.click();
            } catch (ElementClickInterceptedException e) {
                jsExecutor.executeScript("arguments[0].click(true)", paginationNext);
            }

            for (int i = 0; i < card.size(); i++) {
                var title = titleCard.get(i).getText();
                var date = dateCard.get(i).getText();
                if (title.equals(name) && date.contains("Сегодня")) {
                    return true;
                }
            }
        }
        return false;
    }*/

    /*
    public boolean checkingTheCardOnThePage(String name) {
        while (true) {
            for (int i = 0; i < card.size(); i++) {
                var title = titleCard.get(i).getText();
                var date = dateCard.get(i).getText();
                if (title.equals(name) && date.contains("Сегодня")) {
                    return true;
                }
            }

            if (paginationNext.isDisplayed()) {
                try {
                    wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
                    paginationNext.click();
                    //jsExecutor.executeScript("document.querySelector('[class=\"pagination__item\"]').click();");
                } catch (ElementClickInterceptedException e) {
                    jsExecutor.executeScript("arguments[0].click(true)", paginationNext);
                }
            } else {
                break; // Exit the loop if paginationBox is not displayed
            }
        }
        return false;
    }
    */

    // Данная проверка на отображение созданного резюме. Циклом проход по списку.
    public boolean checkingTheCardOnThePage(String name) {
        for (int i = 0; i < card.size(); i++) {
            var title = titleCard.get(i).getText();
            var date = dateCard.get(i).getText();
            if (title.equals(name) && date.contains("Сегодня")) {
                return true;
            }
        }
        return false;
    }

    public boolean switchPageAndCheckingCard(String name) {
        if (paginationNext.isDisplayed()) {
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
            try {
                paginationNext.click();
            } catch (ElementClickInterceptedException e) {
                jsExecutor.executeScript("arguments[0].click(true)", paginationNext);
            }
        }
        for (int i = 0; i < card.size(); i++) {
            var title = titleCard.get(i).getText();
            var date = dateCard.get(i).getText();
            if (title.equals(name) && date.contains("Сегодня")) {
                return true;
            }
        }
        return false;
    }

    //СЗН, подача заявления на предоставление услуги
    public void switchRadioBtn(WebElement element) {

    }

    public void setCvSelect(String text) {
        new Select(cvSelect).selectByVisibleText(text);
    }

    public String getCvSelect() {
        return new Select(cvSelect).getFirstSelectedOption().getText();
    }

    //адрес регистрации
    public void setRegion() {
        new Select(regionSelect).selectByVisibleText("г Санкт-Петербург");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath();
    }

    public void setAddress() throws InterruptedException {
        Thread.sleep(1000);
        jsExecutor.executeScript("arguments[0].click()", addressListbox);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class,'show')]//*[@class='bs-searchbox__input']")));
        fieldForInput.sendKeys("г Санкт-Петербург, пр-кт Приморский");
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='addressField']")));
        new Select(selectAddress).selectByVisibleText("г Санкт-Петербург, пр-кт Приморский");
    }

    public void setCznRegionSelect() {
        new Select(cznRegionSelect).selectByVisibleText("г Санкт-Петербург");
    }

    public void setCznSelect() {
        new Select(cznSelect).selectByVisibleText("СПб ГАУ ЦЗН АЗН Приморского района СПб");
    }

    public void setSwitchBenefit() {
        switchBenefit.sendKeys(Keys.SPACE);
    }

    public void setMirNumberField(String number) {
        mirNumberField.sendKeys(number);
    }

    public void switchRadioButtons() {
        underAgeOf16Radio.sendKeys(Keys.SPACE);
        recipientsOldAgeRadio.sendKeys(Keys.SPACE);
        convictedRadio.sendKeys(Keys.SPACE);
        havePayingJobRadio.sendKeys(Keys.SPACE);
        notariesLawyersIPRadio.sendKeys(Keys.SPACE);
        sellingProductsUnderContractsRadio.sendKeys(Keys.SPACE);
        contractWorkRadio.sendKeys(Keys.SPACE);
        selectedForPaidPositionRadio.sendKeys(Keys.SPACE);
        militaryServiceRadio.sendKeys(Keys.SPACE);
        fullTimeStudentsRadio.sendKeys(Keys.SPACE);
        temporarilyAbsentFromWorkplaceRadio.sendKeys(Keys.SPACE);
        foundersRadio.sendKeys(Keys.SPACE);
        membersOfPeasantFarmRadio.sendKeys(Keys.SPACE);
        professionalIncomeTaxPayersRadio.sendKeys(Keys.SPACE);
        disabledPersonCareField.sendKeys(Keys.SPACE);
        adoptiveParentsField.sendKeys((Keys.SPACE));
    }

    public void switchCheckboxes() {
        familiarizedWithLawCheckbox.sendKeys(Keys.SPACE);
        warningFalseDataCheckbox.sendKeys(Keys.SPACE);
        consentPersonalDataCheckbox.sendKeys(Keys.SPACE);
        personalDataThirdPartiesCheckbox.sendKeys(Keys.SPACE);
        refusalFalseInformationCheckbox.sendKeys(Keys.SPACE);
        fraudulentBenefitCheckbox.sendKeys(Keys.SPACE);
    }

    public void sendButtonClick() {
        try {
            sendApplication.click();
        } catch (ElementClickInterceptedException e) {
            jsExecutor.executeScript("arguments[0].click(true)", sendApplication);
        }
    }

    public String getTitleSuccess() {
        wait.withTimeout(Duration.ofSeconds(45)).until(ExpectedConditions.textToBePresentInElement(titleSuccess,
                "Ваше заявление успешно отправлено!"));
        return titleSuccess.getText();
    }
}
