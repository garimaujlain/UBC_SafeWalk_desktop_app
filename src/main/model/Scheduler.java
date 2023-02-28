package model;

import java.sql.Array;
import java.time.DayOfWeek;
import java.util.*;

public class Scheduler {
    private static List<Volunteer> volunteers;


    static List<String> daysOfWeek = Arrays.asList("Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday");


    public Scheduler(List<Volunteer> volunteers) {
        this.volunteers = volunteers;


    }

    public HashMap<String, List<Volunteer>> makeSchedule() {
        HashMap<String, List<Volunteer>> schedule = new HashMap<>();

        // loop through each day of the week
        for (String day : daysOfWeek) {
            List<Volunteer> availableVolunteers = new ArrayList<>();

            // loop through each employee and check their availability
            for (Volunteer volunteer : volunteers) {
                if (volunteer.getAvailability(day)) {
                    availableVolunteers.add(volunteer);
                }
            }

            // add the available employees to the schedule for this day
            schedule.put(day, availableVolunteers);
        }

        return schedule;
    }


    public void addVolunteer(Volunteer volunteer) {
        this.volunteers.add(volunteer);
    }

    public static Volunteer findVolunteer(String name) {
        for (Volunteer volunteer : volunteers) {
            if (volunteer.getName().equals(name)) {
                return volunteer;
            }
        }
        return null;
    }

    public static List<String> onDuty(String day) {
        List<String> temp = new ArrayList<>();
        for (Volunteer volunteer : volunteers) {
            if (volunteer.getAvailability(day).equals(true)) {
                temp.add(volunteer.getName());
            }

        }
        return temp;
    }



}













