package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class OzonNoutbukiPage {

    private SelenideElement
            filterBrandsShowAll = $x("//div[contains(text(),'Бренды')]/following-sibling::div//span[contains(text(),'Посмотреть все')]"),
            filterBrandsSearchInput = $x("//div[contains(text(),'Бренды')]/following-sibling::div//input[@type='text']"),
            filterBrandsCheckbox = $x("//div[contains(text(),'Бренды')]/following-sibling::div//a/label"),
            searchResultsFiltersActive = $x("//div[@data-widget='searchResultsFiltersActive']//span");

    @Step("Открываем страницу")
    public OzonNoutbukiPage openPage() {
        open("https://www.ozon.ru/category/noutbuki-15692");
        return this;
    }

    @Step("В фильтре \"Бренды\" нажать на \"Посмотреть все\"")
    public OzonNoutbukiPage showAllBrandsFilter() {
        $x("//div[contains(text(),'Цена')]").scrollTo();
        filterBrandsShowAll.click();
        return this;
    }

    @Step("В поиске фильтра ввести бренд \"{value}\"")
    public OzonNoutbukiPage typeBrandName(String value) {
        filterBrandsSearchInput.setValue(value);
        return this;
    }

    @Step("Отметить checkbox бренда")
    public OzonNoutbukiPage chooseBrandName() {
        filterBrandsCheckbox.click();
        return this;
    }

    @Step("Проверяем что отображается фильтр \"{value}\"")
    public OzonNoutbukiPage shouldFiltersActive(String value) {
        $x("//div[@data-widget='catalogResultsBreadCrumbs']").scrollTo();
        searchResultsFiltersActive.shouldHave(text(value));
        return this;
    }
}
