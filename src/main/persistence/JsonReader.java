package persistence;

import model.User;
import model.Volunteer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public User read() throws Exception {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseUser(jsonObject);
    }


    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private User parseUser(JSONObject jsonObject) throws Exception {
        JSONArray jsonVolunteers = jsonObject.getJSONArray("volunteers");
        List<Volunteer> volunteers = new ArrayList<>();

        for (int i = 0; i < jsonVolunteers.length(); i++) {
            JSONObject jsonVolunteer = jsonVolunteers.getJSONObject(i);
            String name = jsonVolunteer.getString("name");

            String gender = jsonVolunteer.getString("gender");
            int age = jsonVolunteer.getInt("age");

            JSONArray jsonArray = jsonVolunteer.getJSONArray("availability");
            List<Boolean> availability = new ArrayList<>();
            for (int j = 0; j < jsonArray.length(); j++) {
                availability.add(jsonArray.getBoolean(j));
            }


            Volunteer volunteer = new Volunteer(name, age, gender, availability);
            volunteers.add(volunteer);
        }

        return new User(volunteers);
    }


}
