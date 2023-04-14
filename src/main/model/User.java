package model;


public class User {
    private String name;
    private int age;
    private String gender;
    private String volunteer;


    // Constructor for  User class that takes (string, int, string, string) input



    public User(String name, int age, String gender, String volunteer) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.volunteer = volunteer;

    }



    // Constructor for  User class that takes no input
    public User() {
        this.name = null;
        this.age = 0;
        this.gender = null;
        this.volunteer = null;


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


