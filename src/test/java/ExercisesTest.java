import models.Vehicle;
import org.junit.Before;
import org.junit.Test;
import rest.RentalCarsResource;
import utils.JsonUtils;
import utils.TextUtils;

import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by luke_c on 26/04/2017.
 */
public class ExercisesTest {
    private static List<Vehicle> vehicleList;

    private static String EXPECTED_PRICE;
    private static String EXPECTED_SPECIFICATION;
    private static String EXPECTED_RATING;
    private static String EXPECTED_SCORE;


    @Before
    public void init() {
        // Get the list of vehicles from the JSON file
        vehicleList = JsonUtils.getVehicleList();

        // Load the expected results
        EXPECTED_PRICE = TextUtils.loadFile("src/main/resources/price.txt");
        EXPECTED_SPECIFICATION = TextUtils.loadFile("src/main/resources/specification.txt");
        EXPECTED_RATING = TextUtils.loadFile("src/main/resources/rating.txt");
        EXPECTED_SCORE = TextUtils.loadFile("src/main/resources/score.txt");
    }

    @Test
    public void testSortByPriceAscending() {
        String actualResult = RentalCarsCodingTest.sortByPriceAscending(vehicleList).collect(Collectors.joining("\n"));
        assertEquals(EXPECTED_PRICE, actualResult);
    }

    @Test
    public void testShowSpecification() {
        String actualResult = vehicleList.stream().map(Vehicle::toString).collect(Collectors.joining("\n"));
        assertEquals(EXPECTED_SPECIFICATION, actualResult);
    }

    @Test
    public void testSortByRatingPerCarTypeDescending() {
        String actualResult = RentalCarsCodingTest.sortByRatingPerCarTypeDescending(vehicleList).collect(Collectors.joining("\n"));
        assertEquals(EXPECTED_RATING, actualResult);
    }

    @Test
    public void testSortByScoreDescending() {
        String actualResult = RentalCarsCodingTest.sortByScoreDescending(vehicleList).collect(Collectors.joining("\n"));
        assertEquals(EXPECTED_SCORE, actualResult);
    }
}
