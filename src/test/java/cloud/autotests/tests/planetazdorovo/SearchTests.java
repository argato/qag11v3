package cloud.autotests.tests.planetazdorovo;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

import cloud.autotests.config.planetazdorovo.App;
import cloud.autotests.tests.TestBase;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Owner("arina_ng")
@Feature("Поиск")
@Story("Поиск валидных значений")
@Tags({@Tag("smoke"), @Tag("planetazdorovo")})
public class SearchTests extends TestBase {

  //todo PopUpHelper popUpHelper = new PopUpHelper();

  @BeforeAll
  static void configureBaseUrl() {
    RestAssured.baseURI = App.config.apiUrl();
    Configuration.baseUrl = App.config.webUrl();
  }

  @Test
  @DisplayName("Строка в нижнем регистре")
  @Severity(SeverityLevel.CRITICAL)
  void validStringSearchTest() {
    step("Open main page", () ->
        open(""));

    $(".popup-city-accept .popup__close ").click();
    step("Поиск по строке {searchedValue}", (step) -> {
      String searchedValue = "матрас";
      $(".header-sub .search [name='q']").setValue(searchedValue);
      $(".header-sub .search button.icon-search").click();
    });
    step("Проверка наличия результатов поиска", (step) -> {
      $$(".card-list__element").shouldHave(CollectionCondition.sizeGreaterThan(0));
    });
  }
}