import pages.Authorization;
import pages.MainCandidate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class CandidateServicesTest extends TestBase {

    @Test
    @DisplayName("Услуга 1.1: Содействие гражданам в поиске подходящей работы")
    public void createDeclaration() throws InterruptedException {
        //arrange
//        LogInTest login = new LogInTest();
        MainCandidate page = new MainCandidate(driver, wait);
        Authorization login = new Authorization(driver, wait);
        page.open();
        page.acceptCookiesAndRegion();
//        page.header.enterButton.click();
        login.loginCandidate("+79199259000", "q1eQ1=-3");
//        login.candidate();
        //act
        page.megaMenu.click();
//        page.clickOnMenu();
        page.allServices.click();
        page.declarationBtn.click();
        page.radioClaim.sendKeys(Keys.SPACE);
        page.setCvSelect("Дровосек");
        page.setRegion();
        page.setAddress();
        page.clientAddressHouse.sendKeys("12");
//        page.setCznRegionSelect();
        page.setCznSelect();
        page.setSwitchBenefit();
        page.setMirNumberField("2222960781452222");
        page.switchRadioButtons();
        page.switchCheckboxes();
        page.sendButtonClick();
        //assert
        Assertions.assertAll(
//                () -> Assertions.assertTrue(page.checkBtn.isDisplayed(), "Страница не открылась"),
                () -> Assertions.assertEquals("Ваше заявление успешно отправлено!",
                        page.getTitleSuccess(), "Заголовок страницы не совпадает")
        );
    }
}
