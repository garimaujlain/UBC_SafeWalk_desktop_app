package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;



public class Volunteer {
    private String name;
    private int age;
    private String gender;
    private ArrayList<Boolean> availability;

    public Volunteer(String name, int age, String gender, List<Boolean> availability) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.availability = (ArrayList<Boolean>) availability;
    }


    public String getName() {
        return name;
    }







    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public static void addDay(Volunteer volunteer, String day) {
        Boolean availability = volunteer.getAvailability(day);
        if (availability == null) {
            System.out.println("Invalid day!");
            return;
        }
        if (availability) {
            System.out.println("Your already available on this day ");
            return;
        }
        int index = Scheduler.daysOfWeek.indexOf(day);
        volunteer.getAvailabilityList().set(index, true);
        System.out.println("Your availability on " + day + " has been updated.");
    }

    public static void deleteDay(Volunteer volunteer, String day) {
        Boolean availability = volunteer.getAvailability(day);
        if (availability == null) {
            System.out.println("Invalid day!");
            return;
        }
        if (availability.equals(false)) {
            System.out.println("You are already unavailable on this day ");
            return;
        }
        int index = Scheduler.daysOfWeek.indexOf(day);
        volunteer.getAvailabilityList().set(index, false);
        System.out.println("Congratulation! Your availability on " + day + " has been updated.");
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void newName(Volunteer volunteer, String name) {

        if (volunteer != null) {
            volunteer.setName(name);
        } else {
            return;
        }
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void newAge(Volunteer volunteer, Integer age) {

        if (volunteer != null) {
            volunteer.setAge(age);
        } else {
            return;
        }
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static void newGender(Volunteer volunteer, String gender) {

        if (volunteer != null) {
            volunteer.setGender(gender);
        } else {
            return;
        }
    }




    public Boolean getAvailability(String day) {
        if (day.equals("Monday")) {
            return availability.get(0);
        } else if (day.equals("Tuesday")) {
            return availability.get(1);
        } else if (day.equals("Wednesday")) {
            return availability.get(2);
        } else if (day.equals("Thursday")) {
            return availability.get(3);
        } else if (day.equals("Friday")) {
            return availability.get(4);
        } else if (day.equals("Saturday")) {
            return availability.get(5);
        } else if (day.equals("Sunday")) {
            return availability.get(6);
        } else {
            return null;
        }

    }

    public List<Boolean> getAvailabilityList() {
        return availability;
    }


}


