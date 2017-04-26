package rest;

import models.*;
import utils.JsonUtils;
import utils.StreamUtils;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by luke_c on 26/04/2017.
 */
@Path("rentalcars")
public class RentalCarsResource {
    // Get the list of vehicles from the JSON file
    private static List<Vehicle> vehicleList = JsonUtils.getVehicleList();
    private Gson gson = new Gson();

    @Path("/price")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPriceInformation() {
        List<PriceJsonResponse> response = vehicleList
                .stream()

                // First we sort by price in ascending order
                .sorted(Comparator.comparing(Vehicle::getPrice))

                // Map to our new JSON response format
                .map(PriceJsonResponse::new)

                // Collect into a list
                .collect(Collectors.toList());

        // Convert to JSON
        return gson.toJson(response);
    }

    @Path("/specification")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getVehicleSpecifications() {
        List<SpecificationJsonResponse> response = vehicleList
                .stream()

                // Map to our new JSON response format
                .map(SpecificationJsonResponse::new)

                // Collect into a list
                .collect(Collectors.toList());

        // Convert to JSON
        return gson.toJson(response);
    }

    @Path("/rating")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCarTypeRatings() {
        List<RatingJsonResponse> response = vehicleList
                .stream()

                // First we sort by rating in descending order
                .sorted(Comparator.comparing(Vehicle::getRating).reversed())

                // As the list is now sorted, we can safely remove all subsequent entries of a car type, only taking
                // the first occurrence as it will be the highest rated
                .filter(StreamUtils.distinctByKey(vehicle -> vehicle.getSippDetails().getCarType()))

                // Map to our new JSON response format
                .map(RatingJsonResponse::new)

                // Collect into a list
                .collect(Collectors.toList());

        // Convert to JSON
        return gson.toJson(response);
    }

    @Path("/score")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getVehicleScores() {
        List<ScoreJsonResponse> response = vehicleList
                .stream()

                // First we sort by the sum of scores in descending order
                .sorted(Comparator.comparing(Vehicle::getSumOfScores).reversed())

                // Map to our new JSON response format
                .map(ScoreJsonResponse::new)

                // Collect into a list
                .collect(Collectors.toList());

        // Convert to JSON
        return gson.toJson(response);
    }

}