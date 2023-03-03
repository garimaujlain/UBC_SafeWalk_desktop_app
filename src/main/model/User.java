package model;


import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private String gender;
    private String volunteer;


    public User(String name, int age, String gender, String volunteer) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.volunteer = volunteer;
    }

    public User() {
        this.name = null;
        this.age = 0;
        this.gender = null;
        this.volunteer = null;

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

    public String getAssigned() {
        return volunteer;
    }

//    public void updateUser(String name, int age, String gender, String volunteer) {
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.volunteer = volunteer;
//    }




}



