package business;

import controls.MainPage;
import controls.SearchResultsPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class CustomerOperations {
    MainPage mainPage = new MainPage();
    SearchResultsPage resultsPage = new SearchResultsPage();

    @Step
    public void fillTicketsForm(String departureStationName, String arrivalStationName, String travelDate) {
        mainPage = open("http://rw.by", MainPage.class);
        mainPage.fillFromField(departureStationName);
        mainPage.fillToField(arrivalStationName);
        mainPage.fillDateField(travelDate);
        mainPage.submit();
    }

    @Step
    public boolean verifyOneWayRadioButtonSelectedByDefault() {
        return resultsPage.isOneWayRadioButtonSelectedByDefault();
    }

    @Step
    public void verifyFilterByEregistration() {
        resultsPage.selectERegistrationCheckbox();
        resultsPage.isOnlySearchResultsWithERegistrationPresent();
    }

    @Step
    public void verifyFourDateFilters() {
        resultsPage.isFourDateFiltersPresent();
    }

    @Step
    public boolean verifyImagesQuantity(int imagesQuantity) {
        return resultsPage.getImagesQuantity() > imagesQuantity;
    }
}
