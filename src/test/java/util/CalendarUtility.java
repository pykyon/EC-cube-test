package util;

import java.util.Calendar;

/**
 * Created by kenichiro_ota on 2014/04/24.
 */
public class CalendarUtility {
    public static Calendar getImmediateDayOfWeek(Calendar current, int dayOfWeek) {
        Calendar immediateDayOfWeek = (Calendar) current.clone();
        immediateDayOfWeek.add(Calendar.DAY_OF_MONTH, 1);

        while (immediateDayOfWeek.get(Calendar.DAY_OF_WEEK) != dayOfWeek) {
            immediateDayOfWeek.add(Calendar.DAY_OF_MONTH, 1);
        }
        return immediateDayOfWeek;
    }
}
