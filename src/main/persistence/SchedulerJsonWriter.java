package persistence;

import model.Scheduler;
import model.Volunteer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

//adapted from JsonSerializationDemo
public class SchedulerJsonWriter {
    //private static final String FILENAME = "./data/cookbook.json";

    //public static void write(Cookbook cookbook) throws IOException {
    //    write(cookbook, FILENAME);
    //}

    public static void write(Scheduler scheduler, String filePath) throws IOException, JSONException {
        // Create a JSON array of recipe JSON objects
        JSONArray schedulerJsonArray = new JSONArray();
        for (Volunteer volunteer : scheduler.getVolunteers()) {
            JSONObject volunteerJsonObject = volunteer.toJson();
            schedulerJsonArray.put(volunteerJsonObject);
        }

        // Create a JSON object with the recipe array
        JSONObject json = new JSONObject();
        json.put("volunteers", schedulerJsonArray);

        // Write the JSON object to a file
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(json.toString());
        try {
            fileWriter.close();
        } finally {
            System.out.println("Closed");

        }
    }
}