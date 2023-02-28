package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VolunteerTest {

    @Test
    public void testVolunteer() {
        ArrayList<Boolean> availability = new ArrayList<Boolean>(Arrays.asList(true, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("John Doe", 25, "Male", availability);

        assertEquals(volunteer.getName(), "John Doe");
        assertEquals(volunteer.getAge(), 25);
        assertEquals(volunteer.getGender(), "Male");
        assertTrue(volunteer.getAvailability("Monday"));
        assertFalse(volunteer.getAvailability("Tuesday"));
        assertTrue(volunteer.getAvailability("Wednesday"));
        assertFalse(volunteer.getAvailability("Thursday"));
        assertTrue(volunteer.getAvailability("Friday"));
        assertFalse(volunteer.getAvailability("Saturday"));
        assertTrue(volunteer.getAvailability("Sunday"));
    }
}


