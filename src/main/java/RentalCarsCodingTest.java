import models.Vehicle;
import utils.JsonUtils;
import utils.StreamUtils;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by luke_c on 25/04/2017.
 */
public class RentalCarsCodingTest {
    public static void main(String[] args) {

        // Get the list of vehicles from the JSON file
        List<Vehicle> vehicleList = JsonUtils.getVehicleList();

        // Exercise 1
        System.out.println("\nExercise 1");
        sortByPriceAscending(vehicleList)
                // Then display each vehicle
                .forEach(System.out::println);

        // Exercise 2
        System.out.println("\nExercise 2");
        vehicleList
                // Print out each vehicle using the custom toString method
                .forEach(System.out::println);

        // Exercise 3
        System.out.println("\nExercise 3");
        sortByRatingPerCarTypeDescending(vehicleList)
                // Then display each vehicle
                .forEach(System.out::println);

        // Exercise 4
        System.out.println("\nExercise 4");
        sortByScoreDescending(vehicleList)
                // Then display each vehicle
                .forEach(System.out::println);
    }

    // Package private for testing
    static Stream<String> sortByPriceAscending(List<Vehicle> vehicleList) {
        return vehicleList
                .stream()

                // First we sort by price in ascending order
                .sorted(Comparator.comparing(Vehicle::getPrice))

                // We map the output to a more readable format
                .map(vehicle -> "{" + vehicle.getName() + "} - {" + vehicle.getPrice() + "}");
    }

    // Package private for testing
    static Stream<String> sortByRatingPerCarTypeDescending(List<Vehicle> vehicleList) {
        return vehicleList
                .stream()

                // First we sort by rating in descending order
                .sorted(Comparator.comparing(Vehicle::getRating).reversed())

                // As the list is now sorted, we can safely remove all subsequent entries of a car type, only taking
                // the first occurrence as it will be the highest rated
                .filter(StreamUtils.distinctByKey(vehicle -> vehicle.getSippDetails().getCarType()))

                // We map the output to a readable format
                .map(vehicle -> "{" + vehicle.getName() + "} - {" + vehicle.getSippDetails().getCarType() + "} - {"
                        + vehicle.getSupplier() + "} - {" + vehicle.getRating() + "}");
    }

    // Package private for testing
    static Stream<String> sortByScoreDescending(List<Vehicle> vehicleList) {
        return vehicleList
                .stream()

                // First we sort by the sum of scores in descending order
                .sorted(Comparator.comparing(Vehicle::getSumOfScores).reversed())

                // We map the output to a readable format
                .map(vehicle -> "{" + vehicle.getName() + "} - {" + vehicle.getVehicleScore() + "} - {"
                        + vehicle.getRating() + "} - {" + vehicle.getSumOfScores() + "}");
    }
}
