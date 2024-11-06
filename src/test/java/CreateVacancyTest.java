import pages.Authorization;
import pages.MainEmployer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CreateVacancyTest extends TestBase {

    List<String> vacancyNames;

    {
        vacancyNames = List.of(new String[]{
                "Исследователь приключений",
                "Вкусовой тестировщик",
                "Профессиональный путешественник",
                "Тестировщик парков аттракционов",
                "Астроном-поисковик инопланетян",
                "Специалист по робототехнике для домашних животных",
                "Специалист по исследованию сновидений",
                "Дегустатор шоколада",
                "Эксперт по оценке качества сна",
                "Аналитик данных о покупках в магазинах",
                "Специалист по анимации данных",
                "Астрофотограф",
                "Морской биолог",
                "Разработчик игр с ИИ",
                "Архитектор умных городов",
                "Космический археолог"});
    }

    List<String> typeVacancy = List.of(new String[]{
            "Ничего не выбрано",
            "Временное трудоустройство для несовершеннолетних граждан",
            "Временное трудоустройство",
            "Общественная работа"});

    String type = typeVacancy.get(0);
    String vacancy = vacancyNames.get(7);

    @Test
    @DisplayName("Создание и публикация вакансии")
    public void createResume() {
        //arrange
        MainEmployer page = new MainEmployer(driver, wait);
        Authorization login = new Authorization(driver, wait);
        page.open();
        page.acceptCookiesAndRegion();
        login.loginEmployer("79336099755", "84a7t_!LfW");
        //act
        page.newVacancy.click();
        page.setVacancy(vacancy);
        page.setOccupation("Специалист");
        page.setFieldWork();
        //тип вакансии
        page.setTypeVacancy(type);
        //page.setCzn();
        //------------------------
        page.inputResponsibilities("Обязанности");
        page.inputRequirements("Требования");
        page.contactPersonInput.sendKeys("Мария");
        page.phone.sendKeys("9121213531");
        //page.publishButtonClick(); кнопка модального окна
        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals("Вакансии компании", page.getTitleText(),
                        "Текст заголовка не тот")
        );
    }
}
