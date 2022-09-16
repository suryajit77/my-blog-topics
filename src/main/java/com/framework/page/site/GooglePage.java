package com.framework.page.site;

import com.framework.page.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class GooglePage extends BasePage {

    private static final String GOOGLE_SEARCH_COMPONENT = "//form[@role='search']/parent::div";
    private static final String SEARCH_INPUT_FIELD = "//input[@title='Search']";
    private static final String GOOGLE_SEARCH_BTN = "btnk";
    private static final String ADDITIONAL_LANGUAGES_LIST = "//div[@id='gws-output-pages-elements-homepage_additional_languages__als']/div/a";

    @FindBy(xpath = GOOGLE_SEARCH_COMPONENT)
    public WebElement googleSearchComponent;

    @FindBy(xpath = SEARCH_INPUT_FIELD)
    public WebElement searchInputField;

    @FindBy(xpath = GOOGLE_SEARCH_BTN)
    private List<WebElement> googleSearchBtnList;

    @FindBy(xpath = ADDITIONAL_LANGUAGES_LIST)
    public List<WebElement> additionalLanguagesList;

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage isPageLoaded() {
        waitForPageToLoad();
        return this;
    }
}
