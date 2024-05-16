import pages.Authorization;
import pages.MainEmployer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class EmployeeServicesTest extends TestBase {

    @Test
    @DisplayName("Услуга 1.2: Содействие работодателям в подборе необходимых работников")
    public void createDeclaration() throws InterruptedException {
        //arrange
        MainEmployer page = new MainEmployer(driver, wait);
        Authorization login = new Authorization(driver, wait);
        page.open();
        page.acceptCookiesAndRegion();
        login.loginEmployer("79199259000", "q1eQ1=-3");
        //act
        page.header.megaMenu.click();
        page.header.allServices.click();
        page.declarationBtn.click();
        page.setCompanyFormField();
        page.setRegion();
        page.setAddress();
        page.companyAddressHouseField.sendKeys("12");
        page.factAddressField.sendKeys(Keys.SPACE);
        page.setCznRegionSelect();
        page.setCznSelect();
        page.infoEmployeesClick();
        page.setSelectVacancy();
        page.sendButtonClick();
        //assert
        Assertions.assertAll(
                () -> Assertions.assertTrue(page.checkBtn.isDisplayed(), "Страница не открылась"),
                () -> Assertions.assertEquals("Ваше заявление успешно отправлено!",
                        page.getTitleSuccess(), "Заголовок страницы не совпадает")
        );
    }
}
