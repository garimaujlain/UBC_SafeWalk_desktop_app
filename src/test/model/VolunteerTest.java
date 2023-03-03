package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VolunteerTest {

    @Test
    public void testVolunteer() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
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

    @Test
    public void testGetName() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("John Smith", 25, "Male", availability);
        assertEquals("John Smith", volunteer.getName());
    }

    @Test
    public void testGetAge() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("John Smith", 25, "Male", availability);
        assertEquals(25, volunteer.getAge());
    }

    @Test
    public void testGetGender() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("John Smith", 25, "Male", availability);
        assertEquals("Male", volunteer.getGender());
    }

    @Test
    public void testGetAvailability() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("John Smith", 25, "Male", availability);
        assertTrue(volunteer.getAvailability("Monday"));
        assertFalse(volunteer.getAvailability("Tuesday"));
        assertTrue(volunteer.getAvailability("Wednesday"));
        assertFalse(volunteer.getAvailability("Thursday"));
        assertTrue(volunteer.getAvailability("Friday"));
        assertFalse(volunteer.getAvailability("Saturday"));
        assertTrue(volunteer.getAvailability("Sunday"));
        assertNull(volunteer.getAvailability("Invalid day"));
    }

    @Test
    public void testAddDay() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(false, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("John Smith", 25, "Male", availability);
        Volunteer.addDay(volunteer, "Monday");
        assertTrue(volunteer.getAvailability("Monday"));
    }

    @Test
    public void testDeleteDay() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, true, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("Garima Smith", 28, "Male", availability);
        Volunteer.deleteDay(volunteer, "Tuesday");
        assertFalse(volunteer.getAvailability("Tuesday"));
    }

    @Test
    public void testNewName() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("Garima Smith", 35, "Male", availability);
        Volunteer.newName(volunteer, "Angad Singh");
        assertEquals("Angad Singh", volunteer.getName());
    }

    @Test
    public void testNewAge() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("Dash Smith", 25, "Male", availability);
        Volunteer.newAge(volunteer, 45);
        assertEquals(45, volunteer.getAge());
    }

    @Test
    public void testNewGender() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("John Smith", 25, "Male", availability);
        Volunteer.newGender(volunteer, "Male");
        assertEquals("Male", volunteer.getGender());
    }












}
