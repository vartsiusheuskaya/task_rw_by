package controls.blocks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import utils.DateUtil;

import java.time.LocalDate;

public class DatePickerBlock {
    public void selectTravelDate(String travelDate) {
        LocalDate dateFormatted = DateUtil.getDateFormatted(travelDate);
        String monthAndYearForTravel = String.valueOf((dateFormatted.getMonth().getValue() - 1)) + "," + String
                .valueOf((dateFormatted.getYear()));
        String dayForTravel = String.valueOf(dateFormatted.getDayOfMonth());
        Selenide.$$(String.format("#ui-datepicker-div td[onclick*='%s'] .ui-state-default", monthAndYearForTravel))
                .findBy(Condition.text(dayForTravel)).click();
    }
}
