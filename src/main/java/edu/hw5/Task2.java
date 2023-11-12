package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {


    public static List<LocalDate> findFridaysThe13th(int year) {
        List<LocalDate> fridaysThe13th = new ArrayList<>();
        for (Month month : Month.values()) {
            LocalDate date = LocalDate.of(year, month, 13);

            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridaysThe13th.add(date);
            }
        }
        return fridaysThe13th;
    }

    public static LocalDate findNextFridayThe13(LocalDate date) {
        LocalDate currentDate = date;
        currentDate = currentDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        while(currentDate.getDayOfMonth() != 13) {
            currentDate = currentDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return currentDate;
    }

}
