package za.co.loans;

import org.joda.time.Years;
import org.junit.Test;
import za.co.loans.service.utils.IdNumberUtils;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

public class IdNumberTest {

    @Test
    public void getAgeShouldReturnValidAge() {
        String givenIdNumber = "8901025391084";
        int expectedAge = Year.now().getValue() - 1989;

        Years actualAge = IdNumberUtils.INSTANCE.getAge(givenIdNumber);

        assertThat(actualAge.getYears()).isEqualTo(expectedAge);
    }

    @Test
    public void getAgeShouldReturnZero() {
        String givenIdNumber = "blabla";

        Years actualAge = IdNumberUtils.INSTANCE.getAge(givenIdNumber);

        assertThat(actualAge).isEqualTo(Years.ZERO);
    }

}
