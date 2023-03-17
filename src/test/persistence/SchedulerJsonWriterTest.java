package persistence;


import model.Scheduler;
import model.Volunteer;
import org.json.JSONException;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SchedulerJsonWriterTest {
    private SchedulerJsonWriter writer;


    @Test
    void testWriterInvalidFile() {
        try {

            Scheduler testScheduler = new Scheduler();
            writer = new SchedulerJsonWriter();

            SchedulerJsonWriter.write(testScheduler, "./data/my\0illegal:fileName.json");
            fail("IOException was expected");
        } catch (IOException | JSONException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyCookbook() {
        try {
            Scheduler testScheduler = new Scheduler();

            SchedulerJsonWriter.write(testScheduler, "./data/testWriterEmptyScheduler.json");
            Scheduler scheduler = SchedulerJsonReader.read("./data/testWriterEmptyScheduler.json");
            assertEquals(0, scheduler.getVolunteers().size());
        } catch (IOException | JSONException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralCookbook() {
        try {
            Scheduler scheduler = new Scheduler();

            ArrayList<Boolean> availability1 = new ArrayList<>(Arrays.asList(false, false, true, false, true, false, true));
            ArrayList<Boolean> availability2 = new ArrayList<>(Arrays.asList(true, true, true, false, true, false, true));


            Volunteer volunteer1 = new Volunteer("John Dave", 25, "Male", availability1);
            Volunteer volunteer2 = new Volunteer("Garima Singh", 46, "Male", availability2);

            scheduler.addVolunteer(volunteer1);
            scheduler.addVolunteer(volunteer2);
            SchedulerJsonWriter.write(scheduler, "./data/testWriterGeneralScheduler.json");

            // Read the written cookbook file and compare it to the original cookbook
            Scheduler scheduler1 = SchedulerJsonReader.read("./data/testWriterGeneralScheduler.json");
            assertEquals(scheduler.getVolunteers().size(), scheduler1.getVolunteers().size());
            assertEquals(scheduler.getVolunteers().get(0).getName(), scheduler1.getVolunteers().get(0).getName());
            assertEquals(scheduler.getVolunteers().get(1).getName(), scheduler1.getVolunteers().get(1).getName());
        } catch (IOException | JSONException e) {
            fail("Exception should not have been thrown");
        }
    }

}