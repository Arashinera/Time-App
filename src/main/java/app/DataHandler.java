package app;

import net.time4j.ClockUnit;
import net.time4j.Duration;
import net.time4j.PrettyTime;
import net.time4j.format.TextWidth;

import java.util.Locale;

public class DataHandler {

    public static Duration<ClockUnit> newTimeFormat (int timeInSeconds) {
        return Duration.of(timeInSeconds, ClockUnit.SECONDS).with(Duration.STD_CLOCK_PERIOD);
    }

    public static String newTimeFormatOutput (Duration<ClockUnit> duration){
        return Duration.Formatter.ofPattern(ClockUnit.class, "hh:mm:ss").format(duration);
    }

    public static String newLocaleTimeFormatOutput (Duration<ClockUnit> duration, int choice){
        if (choice == 1){
            return PrettyTime.of(Locale.ENGLISH).print(duration, TextWidth.WIDE);
        } else if (choice == 2) {
            return PrettyTime.of(Locale.GERMAN).print(duration, TextWidth.WIDE);
        } else {
            return PrettyTime.of(Locale.FRENCH).print(duration, TextWidth.WIDE);
        }
    }
}
