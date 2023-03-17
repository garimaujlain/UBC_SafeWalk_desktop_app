package model;


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int age;
    private String gender;
    private String volunteer;
    private List<Volunteer> volunteers = Scheduler.getVolunteers();

    // Constructor for  User class that takes (string, int, string, string) input
    public User(String name, int age, String gender, String volunteer, List<Volunteer> volunteers) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.volunteer = volunteer;
        this.volunteers = volunteers;
    }


    public User(List<Volunteer> temp) {
        this.volunteers = temp;
    }

    public User(String name, int age, String gender, String volunteer) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.volunteer = volunteer;

    }


    public List<Volunteer> temp() {
        return volunteers;
    }

    // Constructor for  User class that takes no input
    public User() {
        this.name = null;
        this.age = 0;
        this.gender = null;
        this.volunteer = null;
        this.volunteers = new ArrayList<>();

    }

    // returns name of user
    public String getName() {
        return name;
    }


    //returns age of user
    public int getAge() {
        return age;
    }


    // returns gender of user
    public String getGender() {
        return gender;
    }


    //returns the name of the volunteer assigned to the user
    public String getAssigned() {
        return volunteer;
    }

    public JSONObject toJson() throws Exception {
        JSONObject json = new JSONObject();

        json.put("volunteers", volunteers);
        json.put("name", name);
        json.put("age", age);
        json.put("gender", gender);
        json.put("volunteer", volunteer);
        return json;
    }
//
//    private JSONArray toVolunteers() {
//        JSONArray jsonArray = new JSONArray();
//
//        for (Volunteer t : volunteers) {
//            jsonArray.put(t.toJson());
//        }
//
//        return jsonArray;
//    }

}



