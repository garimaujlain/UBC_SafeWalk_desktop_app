package model;

import java.util.ArrayList;
import java.util.List;



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

    public Volunteer() {

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
        }
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void newAge(Volunteer volunteer, Integer age) {

        if (volunteer != null) {
            volunteer.setAge(age);
        }
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static void newGender(Volunteer volunteer, String gender) {

        if (volunteer != null) {
            volunteer.setGender(gender);
        }
    }




    public Boolean getAvailability(String day) {
        switch (day) {
            case "Monday":
                return availability.get(0);
            case "Tuesday":
                return availability.get(1);
            case "Wednesday":
                return availability.get(2);
            case "Thursday":
                return availability.get(3);
            case "Friday":
                return availability.get(4);
            case "Saturday":
                return availability.get(5);
            case "Sunday":
                return availability.get(6);
            default:
                return null;
        }

    }

    public List<Boolean> getAvailabilityList() {
        return availability;
    }


}