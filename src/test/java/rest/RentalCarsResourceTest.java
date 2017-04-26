package rest;

import org.junit.Before;
import org.junit.Test;
import utils.TextUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by luke_c on 26/04/2017.
 */
public class RentalCarsResourceTest {

    private static String EXPECTED_PRICE_RESPONSE;
    private static String EXPECTED_SPECIFICATION_RESPONSE;
    private static String EXPECTED_RATING_RESPONSE;
    private static String EXPECTED_SCORE_RESPONSE;

    private RentalCarsResource rentalCarsResource = new RentalCarsResource();

    @Before
    public void init() {
        EXPECTED_PRICE_RESPONSE = TextUtils.loadFile("src/main/resources/priceJson.txt");
        EXPECTED_SPECIFICATION_RESPONSE = TextUtils.loadFile("src/main/resources/specificationJson.txt");
        EXPECTED_RATING_RESPONSE = TextUtils.loadFile("src/main/resources/ratingJson.txt");
        EXPECTED_SCORE_RESPONSE = TextUtils.loadFile("src/main/resources/scoreJson.txt");
    }

    @Test
    public void testPriceCall() {
        assertEquals(EXPECTED_PRICE_RESPONSE, rentalCarsResource.getPriceInformation());
    }

    @Test
    public void testSpecificationCall() {
        assertEquals(EXPECTED_SPECIFICATION_RESPONSE, rentalCarsResource.getVehicleSpecifications());
    }

    @Test
    public void testRatingsCall() {
        assertEquals(EXPECTED_RATING_RESPONSE, rentalCarsResource.getCarTypeRatings());
    }

    @Test
    public void testScoresCall() {
        assertEquals(EXPECTED_SCORE_RESPONSE, rentalCarsResource.getVehicleScores());
    }
}
