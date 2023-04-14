package persistence;

import model.Event;
import model.EventLog;
import model.Scheduler;
import model.Volunteer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

//adapted from JsonSerializationDemo
public class SchedulerJsonWriter {
    //private static final String FILENAME = "./data/temp.json";

    //public static void write(Scheduler scheduler) throws Exception {
    //    write(scheduler, FILENAME);
    //}

    public static void write(Scheduler scheduler, String filePath) throws IOException, JSONException {
        // Create a JSON array of volunteers JSON objects
        JSONArray schedulerJsonArray = new JSONArray();
        for (Volunteer volunteer : scheduler.getVolunteers()) {
            JSONObject volunteerJsonObject = volunteer.toJson();
            schedulerJsonArray.put(volunteerJsonObject);
        }

        // Create a JSON object with the volunteer array
        JSONObject json = new JSONObject();
        json.put("volunteers", schedulerJsonArray);

        // Write the JSON object to a file
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(json.toString());
        try {
            fileWriter.close();
        } finally {
            System.out.println("Closed");
            EventLog.getInstance().logEvent(new Event("Session Saved "));

        }
    }
}