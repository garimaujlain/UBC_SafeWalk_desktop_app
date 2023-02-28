package model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class SchedulerTest {
    @Test
    public void testScheduler() {
        ArrayList<Boolean> availability1 = new ArrayList<Boolean>(Arrays.asList(true, false, true, false, true, false, true));
        ArrayList<Boolean> availability2 = new ArrayList<Boolean>(Arrays.asList(false, true, false, true, false, true, false));
        ArrayList<Boolean> availability3 = new ArrayList<Boolean>(Arrays.asList(true, true, true, true, true, true, true));

        Volunteer volunteer1 = new Volunteer("Garima Ujlain", 21, "Male", availability1);
        Volunteer volunteer2 = new Volunteer("Jai Singh", 35, "Female", availability2);
        Volunteer volunteer3 = new Volunteer("Vrinda Vyas", 70, "Male", availability3);

        List<Volunteer> volunteers = new ArrayList<Volunteer>(Arrays.asList(volunteer1, volunteer2, volunteer3));
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

        assertEquals(schedule.get("Thursday").size(), 2);
        assertTrue(schedule.get("Thursday").contains(volunteer2));
        assertTrue(schedule.get("Thursday").contains(volunteer3));

        assertEquals(schedule.get("Friday").size(), 2);
        assertTrue(schedule.get("Friday").contains(volunteer1));
        assertTrue(schedule.get("Friday").contains(volunteer3));

        assertEquals(schedule.get("Saturday").size(), 2);
        assertFalse(schedule.get("Saturday").contains(volunteer1));
        assertTrue(schedule.get("Saturday").contains(volunteer3));

        assertEquals(schedule.get("Sunday").size(), 2);
        assertTrue(schedule.get("Sunday").contains(volunteer1));

        assertFalse(schedule.get("Sunday").contains(volunteer2));
    }
}



