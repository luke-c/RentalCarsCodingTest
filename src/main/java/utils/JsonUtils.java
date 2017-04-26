package utils;

import models.JsonResponse;
import models.Vehicle;
import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by luke_c on 25/04/2017.
 */
public class JsonUtils {
    // The location of the JSON file we are using
    private static final String JSON_FILE_LOCATION = "src/main/resources/vehicles.json";

    // Return a list of Vehicle objects from the specified JSON file
    public static List<Vehicle> getVehicleList() {
        Gson gson = new Gson();
        return gson.fromJson(JsonUtils.readJsonFromFile(JSON_FILE_LOCATION), JsonResponse.class).getSearch().getVehicleList();
    }

    // Read the JSON data from the specified location
    private static String readJsonFromFile(String location) {
        String filePath = null;
        try {
            Path path = Paths.get(location).toAbsolutePath();
            filePath = Files.lines(path).collect(Collectors.joining());
        } catch (Exception e) {
            System.out.println("IOException occurred" + e);
        }
        return filePath;
    }
}
