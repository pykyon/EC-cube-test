package util;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by kenichiro_ota on 2014/04/24.
 */
public class CalendarUtilityTest {
    @Test
    public void testGetImmediateSaturdayOfWeekWhenTodayIsFriday() throws Exception {
        Calendar friday = Calendar.getInstance();
        friday.clear();
        friday.set(2014, Calendar.APRIL, 25);

        Calendar saturday = Calendar.getInstance();
        saturday.clear();
        saturday.set(2014, Calendar.APRIL, 26);

        assertThat(CalendarUtility.getImmediateDayOfWeek(friday, Calendar.SATURDAY), is(saturday));
    }

    @Test
    public void testGetImmediateSaturdayOfWeekWhenTodayIsSaturday() throws Exception {
        Calendar saturday = Calendar.getInstance();
        saturday.clear();
        saturday.set(2014, Calendar.APRIL, 26);

        Calendar nextSaturday = Calendar.getInstance();
        nextSaturday.clear();
        nextSaturday.set(2014, Calendar.MAY, 3);

        assertThat(CalendarUtility.getImmediateDayOfWeek(saturday, Calendar.SATURDAY), is(nextSaturday));
    }
    
    @Test
    public void testGetImmediateSaturdayOfWeekWhenTodayIsSunday() throws Exception {
        Calendar sunday = Calendar.getInstance();
        sunday.clear();
        sunday.set(2014, Calendar.APRIL, 27);

        Calendar saturday = Calendar.getInstance();
        saturday.clear();
        saturday.set(2014, Calendar.MAY, 3);

        assertThat(CalendarUtility.getImmediateDayOfWeek(sunday, Calendar.SATURDAY), is(saturday));
    }

    @Test
    public void testGetImmediateSundayOfWeekWhenTodayIsSunday() throws Exception {
        Calendar sunday = Calendar.getInstance();
        sunday.clear();
        sunday.set(2014, Calendar.APRIL, 27);

        Calendar nextSaturday = Calendar.getInstance();
        nextSaturday.clear();
        nextSaturday.set(2014, Calendar.MAY, 4);

        assertThat(CalendarUtility.getImmediateDayOfWeek(sunday, Calendar.SUNDAY), is(nextSaturday));
    }
}
