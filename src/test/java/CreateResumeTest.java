import pages.Authorization;
import pages.MainCandidate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class CreateResumeTest extends TestBase {

    String vacation = "Дегустатор шоколада";

    @Test
    @DisplayName("Создание и публикация резюме")
    public void createResume() {
        //arrange
        MainCandidate page = new MainCandidate(driver, wait);
        Authorization login = new Authorization(driver, wait);
        page.open();
        page.acceptCookiesAndRegion();
        page.header.enterButton.click();
        login.loginCandidate("+79199259000", "q1eQ1=-3");
        //act
        page.newResume.click();
//        page.desiredPosition.sendKeys(vacation);
        page.setValue(vacation); //желаемая должность
        page.setField();
        page.salary.sendKeys("148 000");
        page.switchWorkExperience.sendKeys(Keys.SPACE);
        page.publishBtnClick();

        //****
//        page.testSwitchPage();

        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(page.getExpectedUrl(), driver.getCurrentUrl(),
                        "После публикации открылась неверная страница"),
                () -> Assertions.assertEquals("Мои резюме", page.getTitle(),
                        "Неверный заголовок страницы")
                //() -> Assertions.assertTrue(/*page.checkingTheCardOnThePage(vacation)*/ page.switchPageAndCheckingCard(vacation),
                //        "Нет карточки с таким резюме")
        );
    }
}
