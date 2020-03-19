package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String convertDateToPattern(String date, String pattern, String patternToConvert) {
        String fixedDate = date;
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern(patternToConvert);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(fixedDate, formatter).format(newFormatter);
    }

    public static LocalDate getDateFormatted(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, formatter);
    }
}
