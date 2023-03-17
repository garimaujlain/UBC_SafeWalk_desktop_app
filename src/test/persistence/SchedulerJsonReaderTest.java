package persistence;


import model.Scheduler;
import model.Volunteer;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class SchedulerJsonReaderTest {
    private SchedulerJsonReader reader;

    @Test
    void testReaderNonExistentFile() {
        try {
            reader = new SchedulerJsonReader();
            SchedulerJsonReader.read("./data/noSuchFile.json");
            fail("IOException expected");
        } catch (Exception e) {
            // pass
        }
    }


    @Test
    void testReaderEmpty()  {
        try {
            Scheduler testScheduler = new Scheduler();

            //CookbookJsonWriter.write(temp, "./data/testReaderEmptyCookbook.json");
            Scheduler scheduler = SchedulerJsonReader.read("./data/testReaderEmptyCookbook.json");
            assertEquals(0, scheduler.getVolunteers().size());
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
    }



    @Test
    void testWriterGeneralScheduler() {
        try {

            Scheduler testScheduler = new Scheduler();


            ArrayList<Boolean> availability1 = new ArrayList<>(Arrays.asList(false, false, true, false, true, false, true));
            ArrayList<Boolean> availability2 = new ArrayList<>(Arrays.asList(true, true, true, false, true, false, true));


            Volunteer volunteer1 = new Volunteer("John Dave", 25, "Male", availability1);
            Volunteer volunteer2 = new Volunteer("Garima Singh", 46, "Male", availability2);


            testScheduler.addVolunteer(volunteer1);
            testScheduler.addVolunteer(volunteer2);


            // Read the written cookbook file and compare it to the original cookbook
            Scheduler writtenScheduler = SchedulerJsonReader.read("./data/testReaderGeneralCookbook.json");
            assertEquals(writtenScheduler.getVolunteers().size(), 0);
            assertEquals(writtenScheduler.getVolunteers().get(0).getName(), "John");
         //   assertEquals(temp2.getVolunteers().get(1).getName(), writtenScheduler.getVolunteers().get(1).getName());
        } catch (IOException | JSONException e) {
            fail("Exception should not have been thrown");
        }
    }
}