package controls;

import com.codeborne.selenide.Condition;
import controls.blocks.DatePickerBlock;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private void selectStation(String stationName) {
        $$(".ac_even strong").filterBy(Condition.text(stationName)).first().click();
    }

    public void fillFromField(String departureStationName) {
        $("#acFrom").setValue(departureStationName);
        selectStation(departureStationName);
    }

    public void fillToField(String arrivalStationName) {
        $("#acTo").setValue(arrivalStationName);
        selectStation(arrivalStationName);
    }

    public void fillDateField(String travelDate) {
        $("#yDate").click();
        DatePickerBlock datePickerBlock = new DatePickerBlock();
        datePickerBlock.selectTravelDate(travelDate);
    }

    public void submit() {
        $(".std-button").shouldBe(Condition.enabled).click();
    }
}
