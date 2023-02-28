package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;



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


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getVolunteer() {
        return volunteer;
    }

//    public void updateUser(String name, int age, String gender, String volunteer) {
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.volunteer = volunteer;
//    }




}



