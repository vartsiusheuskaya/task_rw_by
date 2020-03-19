package controls;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage {
    public boolean isOneWayRadioButtonSelectedByDefault() {
        return $$(".rasp-filter__radio.active").first().getText().equals("В одну сторону");
    }

    public void selectERegistrationCheckbox() {
        $("span[data-filter-value='eregistration']").click();
    }

    public void isOnlySearchResultsWithERegistrationPresent() {
        ElementsCollection trainInfoBlocks = $$(".sch-table__row-wrap");
        trainInfoBlocks.forEach(block -> block.closest(".svg-tag-er").is(Condition.enabled));
    }

    //there are 4 date filters on the search page instead 5
    public void isFourDateFiltersPresent() {
        $$(".sch-links__link").filter(Condition.visible).shouldHaveSize(4);
    }

    public int getImagesQuantity() {
        return $$("img[src*='.png']").size();
    }
}
