package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


//tests for user class

public class UserTest {
    @Test
    public void testGetName() {
        User user = new User("Garima", 25, "female", "Yes");
        assertEquals("Garima", user.getName());
    }

    @Test
    public void testGetVolunteer() {
        User user = new User("Dave", 40, "male", "Yes");
        assertEquals("Yes", user.getAssigned());
    }



    @Test
    public void testGetGender() {
        User user = new User("Chantal", 20, "male", "Yes");
        assertEquals("male", user.getGender());
    }

    @Test
    public void testGetAge() {
        User user = new User("Vrinda", 33, "male", "No");
        assertEquals(33, user.getAge());
    }

    @Test
    public void testUser1() {

        User user = new User("Gam Doe", 27, "Female", "Max Harding");

        assertEquals(user.getName(), "Gam Doe");
        assertEquals(user.getAge(), 27);
        assertEquals(user.getGender(), "Female");
        assertEquals(user.getAssigned(), ("Max Harding"));

    }

    @Test
    public void testUser2() {

        User temp2 = new User();


    }


}
