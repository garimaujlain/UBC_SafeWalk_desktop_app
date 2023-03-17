package model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Volunteer {
    private String name;
    private String gender;
    private int age;


    private final ArrayList<Boolean> availability;


    //constructur for volunteer class that takes (string, int, string, list<boolean>) as input
    public Volunteer(String name, int age, String gender, List<Boolean> availability) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.availability = (ArrayList<Boolean>) availability;
    }

    //constructur for volunteer class to create an empty volunteer object
    public Volunteer() {
        this.name = null;
        this.age = 0;
        this.gender = null;
        this.availability = new ArrayList<>();

    }


    //returns name of volunteer
    public String getName() {
        return name;
    }


    //returns age of volunteer
    public int getAge() {
        return age;
    }

    //returns gender of volunteer
    public String getGender() {
        return gender;
    }

    // Adds availability (false/true -> true) for a volunteer on the inputted day
    // MODIFIES: this
    // EFFECTS: for inputted day of week, turns availability of given volunteer to boolean value true
    //          indicating that they are now available on that day
    // REQUIRES: day is not null
    public static void addDay(Volunteer volunteer, String day) {

        Boolean temp1 = volunteer.getAvailability(day);

        if (temp1) {
            int pos = Scheduler.daysOfWeek.indexOf(day);
            volunteer.getAvailabilityList().set(pos, true);

            System.out.println("Your already available on this day ");

        }
        int pos = Scheduler.daysOfWeek.indexOf(day);
        volunteer.getAvailabilityList().set(pos, true);
        System.out.println("Your availability on " + day + " has been added tp our system.");
    }


    // deleted availability (true/false -> false) for a volunteer on the inputted day
    // MODIFIES: this
    // EFFECTS: for inputted day of week, turns availability of given volunteer to boolean value false
    //          indicating that they are now unavailable on that day
    // REQUIRES: day is not null
    public static void deleteDay(Volunteer volunteer, String day) {
        Boolean x = volunteer.getAvailability(day);

        if (!x) {
            int pos = Scheduler.daysOfWeek.indexOf(day);
            volunteer.getAvailabilityList().set(pos, false);
            System.out.println("You are already unavailable on this day ");

        }
        int pos = Scheduler.daysOfWeek.indexOf(day);
        volunteer.getAvailabilityList().set(pos, false);
        System.out.println("Congratulation! Your availability on " + day + " has been deleted from our system.");
    }

    // Changes the name of given Volunteer
    // MODIFIES: this
    // EFFECTS: Changes the name of the Volunteer to the inputted name
    public void setName(String name) {
        this.name = name;
    }


    //MODIFIES: this
    //REQUIRES: volunteer is not null
    //EFFECTS: changes the name of the given volunteer to inputted name,
    // or prints error message if volunteer doesn;t exist
    public static void newName(Volunteer volunteer, String name) {

        if (volunteer != null) {
            volunteer.setName(name);
        } else {
            System.out.println("Volunteer under this name doesn't exist");

        }
    }

    // Changes the age of given Volunteer
    // MODIFIES: this
    // EFFECTS: Changes the age of the Volunteer to the inputted age
    public void setAge(Integer age) {
        this.age = age;
    }


    //MODIFIES: this
    //REQUIRES: volunteer is not null
    //EFFECTS: changes the age of the given volunteer
    //          to inputted age, or prints error message if volunteer doesn;t exist
    public static void newAge(Volunteer volunteer, Integer age) {

        if (volunteer != null) {
            volunteer.setAge(age);
        } else {
            System.out.println("Volunteer under this name doesn't exist");

        }
    }


    // Changes the gender of given Volunteer
    // MODIFIES: this
    // EFFECTS: Changes the gender of the Volunteer to the inputted gender
    public void setGender(String gender) {
        this.gender = gender;
    }


    //MODIFIES: this
    //REQUIRES: volunteer is not null
    //EFFECTS: changes the gender of the given volunteer to
    //          inputted gender, or prints error message if volunteer doesn;t exist
    public static void newGender(Volunteer volunteer, String gender) {

        if (volunteer != null) {
            volunteer.setGender(gender);
        } else {
            System.out.println("Volunteer under this name doesn't exist");

        }
    }


    // MODIFIES: nothing
    // EFFECTS: returns a boolean value representing
    //          availability of given volunteer on inputted day
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


    // returns availability for given volunteer
    public ArrayList<Boolean> getAvailabilityList() {
        return availability;

    }

    public static Volunteer fromJson(JSONObject json) throws JSONException {
        String name = json.getString("name");
        int age = json.getInt("age");
        String gender = json.getString("gender");
        JSONArray availabilityJsonArray = json.getJSONArray("availability");
        List<Boolean> availability = new ArrayList<>();
        for (int i = 0; i < availabilityJsonArray.length(); i++) {
            availability.add(availabilityJsonArray.getBoolean(i));
        }
        return new Volunteer(name, age, gender, availability);
    }

    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("gender", gender);
        json.put("age", age);

        JSONArray availabilityJsonArray = new JSONArray(availability);
        json.put("availability", availabilityJsonArray);

        return json;
    }

}