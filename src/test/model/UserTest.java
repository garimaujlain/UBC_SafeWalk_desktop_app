package model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void testGetName() {
        User user = new User("Garima", 25, "female", "Yes");
        assertEquals("Garima", user.getName());
    }

    @Test
    public void testGetVolunteer() {
        User user = new User("David", 40, "male", "Yes");
        assertEquals("Yes", user.getVolunteer());
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


}
