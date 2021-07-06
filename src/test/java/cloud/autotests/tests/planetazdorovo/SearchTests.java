package cloud.autotests.tests.planetazdorovo;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

import allure.AutoMember;
import allure.Layer;
import allure.ManualMember;
import cloud.autotests.helpers.PopUpHelper;
import cloud.autotests.tests.TestBase;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Feature("Поиск")
@Story("Поиск валидных значений")
@Layer("web")
@Owner("anovikova")
@Tags({@Tag("smoke"), @Tag("regress"), @Tag("planetazdorovo")})
public class SearchTests extends TestBase {

  PopUpHelper popUpHelper = new PopUpHelper();

  @BeforeEach
  void openPage() {
    open(Configuration.baseUrl);
  }

  @Test
  @DisplayName("Строка в нижнем регистре")
  @AutoMember("anovikova")
  @ManualMember("divanov")
  @Severity(SeverityLevel.CRITICAL)
  void validStringSearchTest() {
    step("Закрыть попап выбора города", (step) -> {
      popUpHelper.popupCityClose();
    });

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