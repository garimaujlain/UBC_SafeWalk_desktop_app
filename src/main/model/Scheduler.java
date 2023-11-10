package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


//class for scheduler that has list of volunteers
public class Scheduler {
    private static List<Volunteer> volunteers;


    static List<String> daysOfWeek = Arrays.asList("Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday");

    // Constructor for  Scheduler class that takes list of volunteers as input
    public Scheduler(List<Volunteer> volunteers) {
        Scheduler.volunteers = volunteers;


    }

    // Constructor for  Scheduler class that takes no input
    public Scheduler() {
        volunteers = new ArrayList<>();

    }

    // EFFECTS: Makes schedule with all volunteers based on the day of week and their availability
    //          Generates a schedul with all  volunteers based on their availability and
    //          returns a HashMap with days of the week as keys and (lists of volunteers) available on that
    //          particular day as values
    public HashMap<String, List<Volunteer>> makeSchedule() {
        HashMap<String, List<Volunteer>> schedule = new HashMap<>();


        for (String day : daysOfWeek) {
            List<Volunteer> availableVolunteers = new ArrayList<>();


            for (Volunteer volunteer : volunteers) {
                if (volunteer.getAvailability(day)) {
                    availableVolunteers.add(volunteer);
                }
            }


            schedule.put(day, availableVolunteers);
        }

        return schedule;
    }

    // adds a new volunteer to the exisiting list of volunteers
    //MODIFIES: The list of volunteers
    //EFFECTS: Adds input volunteer to the exisitng list of volunteers
    //REQUIRES: A Volunteer as input
    public void addVolunteer(Volunteer volunteer) {
        volunteers.add(volunteer);
        EventLog.getInstance().logEvent(new Event("Volunteer Added :" + volunteer.getName()));
    }





    //finds a volunteer in (list of volunteers) using string name as input
    //MODIFIES: nothing
    //EFFECTS: Returns Volunteer within list of volunteers with given name if found, else returns null
    public static Volunteer findVolunteer(String name) {
        for (Volunteer volunteer : volunteers) {
            if (volunteer.getName().equals(name)) {
                return volunteer;
            }

        }
        return null;

    }


    // gives a list of volunteers available on a particular day of the week
    //Modifies: nothing
    // Effects: Returns list of the names of volunteers available on given day of week
    public static List<String> onDuty(String day) {
        List<String> temp = new ArrayList<>();
        for (Volunteer volunteer : volunteers) {
            if (volunteer.getAvailability(day)) {
                temp.add(volunteer.getName());
            }

        }
        return temp;
    }


    // return list of volunteers
    public List<Volunteer> getVolunteers() {
        return volunteers;
    }


//
//    public JSONObject toJson() throws Exception {
//        JSONObject json = new JSONObject();
//
//        json.put("volunteers", volunteers);
//
//        return json;
//    }

}














