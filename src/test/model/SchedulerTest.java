package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


//tests for scheduler class

public class SchedulerTest {
    @Test
    public void testScheduler1() {
        ArrayList<Boolean> availability1 = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
        ArrayList<Boolean> availability2 = new ArrayList<>(Arrays.asList(false, true, false, true, false, true, false));

        ArrayList<Boolean> availability3 = new ArrayList<>(Arrays.asList(true, true, true, true, true, true, true));

        Volunteer volunteer1 = new Volunteer("Garima Ujlain", 21, "Male", availability1);
        Volunteer volunteer2 = new Volunteer("Jai Singh", 35, "Female", availability2);
        Volunteer volunteer3 = new Volunteer("Vrinda Vyas", 70, "Male", availability3);

        List<Volunteer> volunteers = new ArrayList<>(Arrays.asList(volunteer1, volunteer2, volunteer3));

        Scheduler scheduler = new Scheduler(volunteers);

        HashMap<String, List<Volunteer>> schedule = scheduler.makeSchedule();

        assertEquals(schedule.get("Monday").size(), 2);
        assertTrue(schedule.get("Monday").contains(volunteer1));
        assertTrue(schedule.get("Monday").contains(volunteer3));

        assertEquals(schedule.get("Tuesday").size(), 2);
        assertTrue(schedule.get("Tuesday").contains(volunteer2));
        assertTrue(schedule.get("Tuesday").contains(volunteer3));

        assertEquals(schedule.get("Wednesday").size(), 2);
        assertTrue(schedule.get("Wednesday").contains(volunteer1));
        assertFalse(schedule.get("Wednesday").contains(volunteer2));
        assertTrue(schedule.get("Wednesday").contains(volunteer3));



        assertEquals(schedule.get("Friday").size(), 2);
        assertFalse(schedule.get("Friday").contains(volunteer2));
        assertTrue(schedule.get("Friday").contains(volunteer3));

        assertEquals(schedule.get("Saturday").size(), 2);
        assertFalse(schedule.get("Saturday").contains(volunteer1));


        assertEquals(schedule.get("Sunday").size(), 2);
        assertTrue(schedule.get("Sunday").contains(volunteer1));

        assertFalse(schedule.get("Sunday").contains(volunteer2));
    }

    @Test
    public void testScheduler2() {


        List<Volunteer> volunteers = new ArrayList<>();
        Scheduler scheduler = new Scheduler();


    }
    @Test
    void testOnDuty() {



        ArrayList<Boolean> availability4 = new ArrayList<>(Arrays.asList(false, true, true, false, false, false, true));
        ArrayList<Boolean> availability5 = new ArrayList<>(Arrays.asList(true, false, true, false, false, true, false));
        ArrayList<Boolean> availability6 = new ArrayList<>(Arrays.asList(false, false, true, true, false, true, false));

        Volunteer volunteer4 = new Volunteer("Alice", 25, "Female", availability4);
        Volunteer volunteer5 = new Volunteer("Christian", 30, "Male", availability5);
        Volunteer volunteer6 = new Volunteer("Raj", 35, "Male", availability6);
        List<Volunteer> volunteers = new ArrayList<>(Arrays.asList(volunteer4, volunteer5, volunteer6));
        new Scheduler(volunteers);



        List<String> tuesdayVolunteers = Scheduler.onDuty("Tuesday");
        assertEquals(1, tuesdayVolunteers.size());
        assertTrue(tuesdayVolunteers.contains("Alice"));


        List<String> saturdayVolunteers = Scheduler.onDuty("Saturday");
        assertEquals(2, saturdayVolunteers.size());

        assertTrue(saturdayVolunteers.contains("Christian"));
        assertTrue(saturdayVolunteers.contains("Raj"));
    }

    @Test
    void testAddVolunteer() {
        ArrayList<Boolean> availability4 = new ArrayList<>(Arrays.asList(false, true, true, false, false, false, true));
        ArrayList<Boolean> availability5 = new ArrayList<>(Arrays.asList(true, false, true, false, false, true, false));
        ArrayList<Boolean> availability6 = new ArrayList<>(Arrays.asList(false, false, true, true, false, true, false));
        ArrayList<Boolean> availability7 = new ArrayList<>(Arrays.asList(false, true, true, false, true, false, true));

        Volunteer volunteer4 = new Volunteer("Christian", 25, "Female", availability4);
        Volunteer volunteer5 = new Volunteer("Raj", 30, "Male", availability5);
        Volunteer volunteer6 = new Volunteer("Charlie", 35, "Male", availability6);

        List<Volunteer> volunteers = new ArrayList<>(Arrays.asList(volunteer4, volunteer5, volunteer6));
        Scheduler scheduler = new Scheduler(volunteers);

        Volunteer volunteer7 = new Volunteer("Dane", 40, "Male", availability7);
        scheduler.addVolunteer(volunteer7);
        assertEquals(4, scheduler.getVolunteers().size()); // make sure the new volunteer was added
        assertTrue(scheduler.getVolunteers().contains(volunteer7)); // make sure the new volunteer is in the list
    }

    @Test
    void testFindVolunteer() {

        ArrayList<Boolean> availability4 = new ArrayList<>(Arrays.asList(false, true, true, false, false, false, true));
        ArrayList<Boolean> availability5 = new ArrayList<>(Arrays.asList(true, false, true, false, false, true, false));
        ArrayList<Boolean> availability6 = new ArrayList<>(Arrays.asList(false, false, true, true, false, true, false));

        Volunteer volunteer4 = new Volunteer("Garima", 25, "Female", availability4);
        Volunteer volunteer5 = new Volunteer("Bob", 30, "Male", availability5);
        Volunteer volunteer6 = new Volunteer("Jai", 35, "Male", availability6);
        List<Volunteer> volunteers = new ArrayList<>(Arrays.asList(volunteer4, volunteer5, volunteer6));
        new Scheduler(volunteers);

        Volunteer temp1 = Scheduler.findVolunteer("Garima");
        assertNotNull(temp1); // make sure a volunteer was found
        assertEquals("Garima", temp1.getName()); // make sure it's the right volunteer

        Volunteer temp2 = Scheduler.findVolunteer("Raj");
        assertNull(temp2);
    }

    @Test
    void testMakeSchedule() {

        ArrayList<Boolean> availability4 = new ArrayList<>(Arrays.asList(false, true, true, false, false, false, true));
        ArrayList<Boolean> availability5 = new ArrayList<>(Arrays.asList(true, false, true, false, false, true, false));
        ArrayList<Boolean> availability6 = new ArrayList<>(Arrays.asList(false, false, true, true, false, true, false));

        Volunteer volunteer4 = new Volunteer("Alice", 25, "Female", availability4);
        Volunteer volunteer5 = new Volunteer("chris", 30, "Male", availability5);
        Volunteer volunteer6 = new Volunteer("Ash", 35, "Male", availability6);
        List<Volunteer> volunteers = new ArrayList<>(Arrays.asList(volunteer4, volunteer5, volunteer6));
        Scheduler scheduler = new Scheduler(volunteers);

        HashMap<String, List<Volunteer>> schedule = scheduler.makeSchedule();
        assertEquals(7, schedule.size()); // make sure the schedule has 7 days


        List<Volunteer> tuesdayVolunteers = schedule.get("Tuesday");
        assertTrue(tuesdayVolunteers.contains(volunteer4));
        assertFalse(tuesdayVolunteers.contains(volunteer5));


        List<Volunteer> wednesdayVolunteers = schedule.get("Wednesday");
        List<Volunteer> saturdayVolunteers = schedule.get("Saturday");
        assertTrue(wednesdayVolunteers.contains(volunteer6));
        assertTrue(saturdayVolunteers.contains(volunteer5));
    }


}

