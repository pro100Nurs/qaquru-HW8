package guru.qa.tests;

import guru.qa.enums.NotebookBrands;
import guru.qa.pages.OzonNoutbukiPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

@Owner("pro100Nurs")
public class OzonNoutbukiTest extends TestBase {

    OzonNoutbukiPage page = new OzonNoutbukiPage();

    @ParameterizedTest(name = "Фильтр ноутбуков с брендом {0}")
    @ValueSource(strings = {"Apple", "Lenovo"})
    @Story("Параметризованный тест с @ValueSource")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Blocker")
    @DisplayName("Параметризованный тест с @ValueSource")
    public void checkResultsFilterWithValueSource(String brand) {
        page.openPage()
                .showAllBrandsFilter()
                .typeBrandName(brand)
                .chooseBrandName()
                .shouldFiltersActive(brand);
    }

    @ParameterizedTest(name = "Фильтр ноутбуков с брендом {0} и проверка отображения фильтра {1}")
    @CsvSource(value = {
            "Apple | Бренды: Apple",
            "Lenovo | Бренды: Lenovo"
    }, delimiter = '|')
    @Story("Параметризованный тест с @CsvSource")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Blocker")
    @DisplayName("Параметризованный тест с @CsvSource")
    public void checkResultsFilterWithCsvSource(String brand, String expectedResult) {
        page.openPage()
                .showAllBrandsFilter()
                .typeBrandName(brand)
                .chooseBrandName()
                .shouldFiltersActive(expectedResult);
    }

    @ParameterizedTest(name = "Фильтр ноутбуков с брендом {0} и проверка отображения фильтра {1}")
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    @Story("Параметризованный тест с @CsvFileSource")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Blocker")
    @DisplayName("Параметризованный тест с @CsvFileSource")
    public void checkResultsFilterWithCsvFileSource(String brand, String expectedResult) {
        page.openPage()
                .showAllBrandsFilter()
                .typeBrandName(brand)
                .chooseBrandName()
                .shouldFiltersActive(expectedResult);
    }

    public static Stream<Arguments> checkResultsFilterWithMethodSource() {
        return Stream.of(
                Arguments.of("Apple", "Бренды: Apple"),
                Arguments.of("Lenovo", "Бренды: Lenovo")
        );
    }

    @ParameterizedTest(name = "Фильтр ноутбуков с брендом {0} и проверка отображения фильтра {1}")
    @MethodSource
    @Story("Параметризованный тест с @MethodSource")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Blocker")
    @DisplayName("Параметризованный тест с @MethodSource")
    public void checkResultsFilterWithMethodSource(String brand, String expectedResult) {
        page.openPage()
                .showAllBrandsFilter()
                .typeBrandName(brand)
                .chooseBrandName()
                .shouldFiltersActive(expectedResult);
    }

    @ParameterizedTest(name = "Фильтр ноутбуков с брендом {0}")
    @EnumSource(value = NotebookBrands.class)
    @Story("Параметризованный тест с @EnumSource")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Blocker")
    @DisplayName("Параметризованный тест с @EnumSource")
    public void checkResultsFilterWithEnumSource(NotebookBrands brand) {
        page.openPage()
                .showAllBrandsFilter()
                .typeBrandName(brand.name())
                .chooseBrandName()
                .shouldFiltersActive(brand.name());
    }
}
