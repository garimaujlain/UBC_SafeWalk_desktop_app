package persistence;

import model.Scheduler;
import model.Volunteer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

//adapted from JsonSerializationDemo
public class SchedulerJsonReader {
    //private static final String FILENAME = "./data/cookbook.json";

    // public static Cookbook read() throws IOException {
    //     return read(FILENAME);
    // }

    public static Scheduler read(String filePath) throws IOException, JSONException {
        // Read the JSON object from the file
        File file = new File(filePath);
        String jsonStr = new String(Files.readAllBytes(file.toPath()));
        JSONObject json = new JSONObject(jsonStr);

        // Create a cookbook from the recipe JSON objects
        Scheduler scheduler = new Scheduler();
        JSONArray schedulerJsonArray = json.getJSONArray("volunteers");
        for (int i = 0; i < schedulerJsonArray.length(); i++) {
            JSONObject schedulerJsonObject = schedulerJsonArray.getJSONObject(i);
            Volunteer volunteer = Volunteer.fromJson(schedulerJsonObject);
            scheduler.addVolunteer(volunteer);
        }

        return scheduler;
    }
}