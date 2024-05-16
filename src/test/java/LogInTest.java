import pages.Authorization;
import pages.MainCandidate;
import pages.MainEmployer;
import pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LogInTest extends TestBase {
    @Test
    @DisplayName("Авторизация как Соискатель")
    public void candidateLogin() {
        //arrange
        MainPage page = new MainPage(driver, wait);
        page.open();
        //act
        page.header.enterButton.click();
        Authorization auth = new Authorization(driver, wait);
        auth.login("+79199259000", "q1eQ1=-3");
        auth.selectCandidate();
        //assert
        MainCandidate candidate = new MainCandidate(driver, wait);
        Assertions.assertAll(
                () -> Assertions.assertEquals("Мой кабинет", candidate.getTitle(), "Неверная страница")
        );
    }

    @Test
    @DisplayName("Авторизация как Работодатель")
    public void employerLogin() {
        //arrange
        MainPage page = new MainPage(driver, wait);
        page.open();
        //act
        page.header.enterButton.click();
        Authorization auth = new Authorization(driver, wait);
        auth.login("+79199259000", "q1eQ1=-3");
        auth.selectEmployer();
        //assert
        MainEmployer candidate = new MainEmployer(driver, wait);
        Assertions.assertAll(
                () -> Assertions.assertEquals("Кабинет работодателя", candidate.getTitle(),
                        "Неверная страница")
        );
    }

    @Test
    @DisplayName("Авторизация как Соискатель")
    public void candidate() {
        //arrange
        MainPage page = new MainPage(driver, wait);
        page.open();
        //act
        page.header.enterButton.click();
        Authorization auth = new Authorization(driver, wait);
        auth.login("+79199259000", "q1eQ1=-3");
        auth.selectCandidate();
    }

    @Test
    @DisplayName("Авторизация как Работодатель")
    public void employer() {
        //arrange
        MainPage page = new MainPage(driver, wait);
        page.open();
        //act
        page.header.enterButton.click();
        Authorization auth = new Authorization(driver, wait);
        auth.login("+79199259000", "q1eQ1=-3");
        auth.selectEmployer();
    }
}
