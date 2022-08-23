package za.co.loans.service.utils;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static java.util.Objects.isNull;

public class IdNumberUtils {

    public static final IdNumberUtils INSTANCE = new IdNumberUtils();
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyMMdd");

    private IdNumberUtils() {
    }

    public Years getAge(String idNumber) {
        if (isNull(idNumber) || idNumber.trim().length() < 5) {
            return Years.ZERO;
        }

        try {
            LocalDate dateOfBirth = LocalDate.fromDateFields(DATE_FORMAT.parse(idNumber.substring(0, 6)));
            return Years.yearsBetween(dateOfBirth, LocalDate.now());
        } catch (ParseException e) {
            return Years.ZERO;
        }
    }
}
