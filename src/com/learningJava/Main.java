package com.learningJava;

import java.time.LocalDate;
import java.util.*;

public class Main {

    enum WeekDay {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
	// write your code here

        //A list to hold a person's workdays…
        List<WeekDay> annsWorkDays = new ArrayList<>(List.of(WeekDay.MONDAY, WeekDay.TUESDAY, WeekDay.THURSDAY, WeekDay.FRIDAY));

        //creating an EnumSet to hold the data.
        EnumSet<WeekDay> annsDaysSet = EnumSet.copyOf(annsWorkDays);
        System.out.println(annsDaysSet.getClass().getSimpleName()); //RegualarEnumSet -> <= 64 enums --- JumboEnumSet -> >= 64 enums

        annsDaysSet.forEach(System.out::println); //naturally ordered by the ordinal value,

        /*
            The EnumSet is faster than a HashSet of an enum type,
            The EnumMap is faster than a HashMap of an enum type as well.
         */

        //EnumSet Methods:

        //allOf()
        EnumSet allDaysSet = EnumSet.allOf(WeekDay.class);
        System.out.println();
        allDaysSet.forEach(System.out::println);

        //complementOf()
        Set<WeekDay> newPersonDays = EnumSet.complementOf(annsDaysSet);
        //-> this returns the complement of ann's days and the underlying Enum (WeekDays) - difference of all days of the week and ann's days - with just a method call...
        System.out.println();
        newPersonDays.forEach(System.out::println);

        //range()
        Set<WeekDay> businessDays = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
        //this method returns a list of the weekdays within and including the starting point and ending point.
        System.out.println();
        businessDays.forEach(System.out::println);

        //All other methods are same with the HashSet<> so...



        //EnumMap

        System.out.println("-".repeat(34));

        Map<WeekDay, String[]> employeeMap = new EnumMap<WeekDay, String[]>(WeekDay.class);

        //assign working days to different employees
        employeeMap.put(WeekDay.MONDAY, new String[] { "Joyce", "Walker", "Harper", "Dinesh", "Samuel"});
        employeeMap.put(WeekDay.TUESDAY, new String[] { "Joyce", "Walker", "Samuel"});
        employeeMap.put(WeekDay.WEDNESDAY, new String[] { "Joyce", "Walker", "Samuel", "Jey", "AY"});
        employeeMap.put(WeekDay.THURSDAY, new String[] { "Joyce", "Walker", "Samuel"});
        employeeMap.put(WeekDay.FRIDAY, new String[] {"Jey", "AY", "Dinesh"});

        //print the employees workdays and their names...
        employeeMap.forEach(((weekDay, strings) -> System.out.println("Weekday: " + weekDay + "   Employee: " + Arrays.toString(strings))));

        //all other methods here exist in the HashMap...
        //But it is more efficient to use the EnumMap than to use the HashMap on Enums.









    }
}
