package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


// tests for volunteer class

public class VolunteerTest {

    @Test
    public void testVolunteer1() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("John Dane", 25, "Male", availability);

        assertEquals(volunteer.getName(), "John Dane");
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
    public void testVolunteer2() {
        ArrayList<Boolean> availability = new ArrayList();
        Volunteer volunteer = new Volunteer();


    }

    @Test
    public void testGetName() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("John Singh", 22, "Male", availability);
        assertEquals("John Singh", volunteer.getName());
    }

    @Test
    public void testGetAge() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("John Singh", 24, "Male", availability);
        assertEquals(24, volunteer.getAge());
    }

    @Test
    public void testGetGender() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("Raj Smith", 25, "Female", availability);
        assertEquals("Female", volunteer.getGender());
    }

    @Test
    public void testGetAvailability() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("John Smith", 33, "Male", availability);
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

        ArrayList<Boolean> availability1 = new ArrayList<>(Arrays.asList(false, false, true, false, true, false, true));
        ArrayList<Boolean> availability2 = new ArrayList<>(Arrays.asList(true, true, true, false, true, false, true));


        Volunteer volunteer1 = new Volunteer("John Dave", 25, "Male", availability1);
        Volunteer volunteer2 = new Volunteer("Garima Singh", 46, "Male", availability2);
        Volunteer.addDay(volunteer1, "Monday");
        assertTrue(volunteer1.getAvailability("Monday"));


        Volunteer.addDay(volunteer1, "Wednesday");
        assertTrue(volunteer1.getAvailability("Wednesday"));

        Volunteer.addDay(volunteer2, "Monday");
        assertTrue(volunteer2.getAvailability("Monday"));


        Volunteer.addDay(volunteer2, "Saturday");
        assertTrue(volunteer2.getAvailability("Saturday"));
    }

    @Test
    public void testDeleteDay() {
        ArrayList<Boolean> availability1 = new ArrayList<>(Arrays.asList(true, true, true, true, true, false, false));
        ArrayList<Boolean> availability2 = new ArrayList<>(Arrays.asList(true, true, true, false, true, false, true));

        Volunteer volunteer1 = new Volunteer("Jhon Delta", 32, "Female", availability1);
        Volunteer volunteer2 = new Volunteer("Garima Singh", 46, "Male", availability2);
        Volunteer.deleteDay(volunteer1, "Tuesday");
        assertFalse(volunteer1.getAvailability("Tuesday"));
        Volunteer.deleteDay(volunteer1, "Saturday");
        assertFalse(volunteer1.getAvailability("Saturday"));

    }

    @Test
    public void testNewName() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("Garima Smith", 35, "Male", availability);
        Volunteer.newName(volunteer, "Angad Singh");
        assertEquals("Angad Singh", volunteer.getName());

        Volunteer temp = null;
        Volunteer.newName(temp, "garima");
        assertNull(temp);
    }

    @Test
    public void testNewAge() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("Dash Smith", 25, "Male", availability);
        Volunteer.newAge(volunteer, 45);
        assertEquals(45, volunteer.getAge());

        Volunteer volunteer2 = null;
        Volunteer.newAge(volunteer2, 33);
        assertNull(volunteer2);
    }

    @Test
    public void testNewGender() {
        ArrayList<Boolean> availability = new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true));
        Volunteer volunteer = new Volunteer("John Smith", 25, "Male", availability);
        Volunteer.newGender(volunteer, "Male");
        assertEquals("Male", volunteer.getGender());

        Volunteer temp = null;
        Volunteer.newGender(temp, "Female");
        assertNull(temp);
    }












}
