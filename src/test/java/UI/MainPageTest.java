package UI;

import UI.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainPageTest extends TestBase {

    private MainPage page;

    @BeforeEach
    public void preconditions() {
        page = new MainPage(driver, wait);
        page.open();
        page.acceptCookiesAndRegion();
    }

    @Test
    @Owner("@d.zakharov")
    @Description("Переключение на Работодателя на главной странице")
    @DisplayName("Переход к Работодателю")
    public void goToEmployer() {
        //arrange
//        var page = new MainPage(driver);
//        page.open();
        //act
        page.header.tabEmployer.click();
        //assert
        var expectedResult = "Найдите лучшего работника в любой точке России";
        Assertions.assertEquals(expectedResult, page.title.getText(), page.messageInCaseOfFailedTest);
    }

    @Test
    @Owner("@d.zakharov")
    @Description("Открывается страница с поисковой выдачей с конкретной вакансий")
    @DisplayName("Поиск конкретной вакансии")
    public void searchVacancyOnMainPage() {
        //arrange
//        var page = new MainPage(driver, wait);
//        page.open();
        var text = "Повар";
        //act
        page.searchVacancy(text);
        //assert
        Assertions.assertTrue(page.titleContainsText(text), "Поисковая выдача не работает");
    }

    @Test
    @Owner("@d.zakharov")
    @Description("Открывается страница с поисковой выдачей вакансий")
    @DisplayName("Страница поисковой выдачи вакансий")
    public void goToSearchVacancy() {
        //arrange
//        var page = new MainPage(driver, wait);
//        page.open();
        //act
        page.header.searchJobLink.click();
        //assert
        Assertions.assertAll(
                () -> Assertions.assertTrue(page.checkTitle(page.searchVacancy).contains("Работа и вакансии"),
                        "Заголовок страницы не совпадает"),
                () -> Assertions.assertEquals("Поиск вакансий", page.header.getBreadcrumbsText(),
                        "Неверная страница")
        );
    }

    @Test
    @Owner("@d.zakharov")
    @Description("Открывается страница с поисковой выдачей резюме")
    @DisplayName("Страница поисковой выдачи резюме")
    public void goToSearchCV() {
        //arrange
//        var page = new MainPage(driver, wait);
//        page.open();
        //act
        page.header.searchEmployees.click();
        //assert
        Assertions.assertAll(
                () -> Assertions.assertTrue(page.checkTitle(page.searchCV).contains("Резюме соискателей"),
                        "Неверная страница"),
                () -> Assertions.assertEquals("Поиск резюме", page.header.getBreadcrumbsText(),
                        "Неверные хлебные крошки")
        );
    }

    @Test
    @Owner("@d.zakharov")
    @Description("Инфоблок \"Работа для всех\"")
    @DisplayName("Открытие карточек в инфоблоке Работа для всех")
    public void openCardJobsForAll() {
        page.clickOnCard();
        //assert
        var allWindows = driver.getWindowHandles();
        var expectedUrl = "/information-pages/arrivals";
        switchToFirstWindow();
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, allWindows.size(),
                        "После клика не открылось новое окно"),
                () -> Assertions.assertTrue(driver.getCurrentUrl().contains(expectedUrl),
                        "После клика открылась неверная страница")
        );
    }
}
