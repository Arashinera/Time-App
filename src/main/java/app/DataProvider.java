package app;

import net.time4j.ClockUnit;
import net.time4j.Duration;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class DataProvider {

    public static void provideData() {

        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.ENGLISH);

        int choice = 0;
        int timeInSeconds;
        String formattedTime;

        try {
            do {
                System.out.println("""
                        Welcome to the new time format program. Choose the option :
                        1) Convert seconds to format "hh:mm:ss"
                        2) Convert seconds to format "hh hours, mm minutes, ss seconds"
                        0) Exit""");

                choice = input.nextInt();

            } while (choice < 0 || choice > 2);
        } catch (InputMismatchException exception) {
            System.out.println("Please, provide \"int\" data : " + exception.getMessage());
        }

        switch (choice) {
            case 1:

                System.out.println("Please, input your seconds value: ");
                timeInSeconds = input.nextInt();
                Duration<ClockUnit> unit1 = DataHandler.newTimeFormat(timeInSeconds);
                formattedTime = DataHandler.newTimeFormatOutput(unit1);
                System.out.println("Formatted time : \n" + formattedTime);

                break;

            case 2:

                try {
                    do {
                        System.out.println("""
                                Which language format fo you want to use? :
                                1) English
                                2) German
                                3) French""");

                        choice = input.nextInt();

                    } while (choice < 1 || choice > 3);
                } catch (InputMismatchException exception) {
                    System.out.println("Please, provide \"int\" data : " + exception.getMessage());
                }

                System.out.println("Please, input your seconds value: ");
                timeInSeconds = input.nextInt();
                Duration<ClockUnit> unit2 = DataHandler.newTimeFormat(timeInSeconds);
                formattedTime = DataHandler.newLocaleTimeFormatOutput(unit2, choice);
                System.out.println("Formatted time : \n" + formattedTime);

            case 0:
                System.exit(0);
                break;
        }

    }
}
