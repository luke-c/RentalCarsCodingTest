package models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by luke_c on 26/04/2017.
 */
public class VehicleTest {
    private static final double DELTA = 1e-15;

    @Test
    public void testVehicleConstructor() {
        Vehicle vauxhallCorsa = new Vehicle("ECMR", "Vauxhall Corsa", 139.93, "Hertz", 8.9);

        assertEquals("Vauxhall Corsa", vauxhallCorsa.getName());
        assertEquals("ECMR", vauxhallCorsa.getSipp());
        assertEquals(139.93, vauxhallCorsa.getPrice(), DELTA);
        assertEquals("Hertz", vauxhallCorsa.getSupplier());
        assertEquals(8.9, vauxhallCorsa.getRating(), DELTA);

        // Sipp tests
        assertEquals("Economy", vauxhallCorsa.getSippDetails().getCarType());
        assertEquals("4 doors", vauxhallCorsa.getSippDetails().getDoorCarType());
        assertFalse(vauxhallCorsa.getSippDetails().isAutomatic());
        assertTrue(vauxhallCorsa.getSippDetails().isPetrol());
        assertTrue(vauxhallCorsa.getSippDetails().hasAirCon());
    }

    @Test
    public void testGetVehicleScore() {
        Vehicle skodaOctavia = new Vehicle("IDMR", "Skoda Octavia", 236.24, "Hertz", 8.9);
        Vehicle skodaFavia = new Vehicle("CDAR", "Skoda Fabia", 219.71, "Alamo", 7.8);
        Vehicle kiaPicanto = new Vehicle("MBMN", "Kia Picanto", 136.57, "Hertz", 8.9);

        assertEquals(3, skodaOctavia.getVehicleScore());
        assertEquals(7, skodaFavia.getVehicleScore());
        assertEquals(1, kiaPicanto.getVehicleScore());
    }

    @Test
    public void testGetSumOfScores() {
        Vehicle skodaOctavia = new Vehicle("IDMR", "Skoda Octavia", 236.24, "Hertz", 8.9);
        Vehicle skodaFavia = new Vehicle("CDAR", "Skoda Fabia", 219.71, "Alamo", 7.8);
        Vehicle kiaPicanto = new Vehicle("MBMN", "Kia Picanto", 136.57, "Hertz", 8.9);

        assertEquals(11.9, skodaOctavia.getSumOfScores(), DELTA);
        assertEquals(14.8, skodaFavia.getSumOfScores(), DELTA);
        assertEquals(9.9, kiaPicanto.getSumOfScores(), DELTA);
    }

    @Test
    public void testToString() {
        Vehicle fordFocus = new Vehicle("CDMR", "Ford Focus", 157.85, "Hertz", 8.9);

        String expectedResult = "{Ford Focus} - {CDMR} - {Compact} - {5 doors} - {Manual} - {Petrol} - {AC}";
        assertEquals(expectedResult, fordFocus.toString());
    }
}
