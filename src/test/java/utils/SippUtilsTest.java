package utils;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

/**
 * Created by luke_c on 26/04/2017.
 */
public class SippUtilsTest {

    @Test
    public void testGetCarTypes() {
        assertEquals("Mini", SippUtils.CAR_TYPES.get('M'));
        assertEquals("Economy", SippUtils.CAR_TYPES.get('E'));
        assertEquals("Compact", SippUtils.CAR_TYPES.get('C'));
        assertEquals("Intermediate", SippUtils.CAR_TYPES.get('I'));
        assertEquals("Standard", SippUtils.CAR_TYPES.get('S'));
        assertEquals("Full size", SippUtils.CAR_TYPES.get('F'));
        assertEquals("Premium", SippUtils.CAR_TYPES.get('P'));
        assertEquals("Luxury", SippUtils.CAR_TYPES.get('L'));
        assertEquals("Special", SippUtils.CAR_TYPES.get('X'));
    }

    @Test
    public void testGetCarDoorTypes() {
        assertEquals("2 doors", SippUtils.DOORS_CAR_TYPES.get('B'));
        assertEquals("4 doors", SippUtils.DOORS_CAR_TYPES.get('C'));
        assertEquals("5 doors", SippUtils.DOORS_CAR_TYPES.get('D'));
        assertEquals("Estate", SippUtils.DOORS_CAR_TYPES.get('W'));
        assertEquals("Convertible", SippUtils.DOORS_CAR_TYPES.get('T'));
        assertEquals("SUV", SippUtils.DOORS_CAR_TYPES.get('F'));
        assertEquals("Pick up", SippUtils.DOORS_CAR_TYPES.get('P'));
        assertEquals("Passenger Van", SippUtils.DOORS_CAR_TYPES.get('V'));
    }

    @Test
    public void testIsAutomatic() {
        assertTrue(SippUtils.isAutomatic('A'));
        assertFalse(SippUtils.isAutomatic('M'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsAutomatic_illegalArgument() {
        SippUtils.isAutomatic('X');
    }

    @Test
    public void testIsPetrol() {
        assertTrue(SippUtils.isPetrol('N'));
        assertTrue(SippUtils.isPetrol('R'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsPetrol_illegalArgument() {
        SippUtils.isPetrol('X');
    }

    @Test
    public void testHasAircon() {
        assertFalse(SippUtils.hasAirCon('N'));
        assertTrue(SippUtils.hasAirCon('R'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHasAiron_illegalArgument() {
        SippUtils.hasAirCon('X');
    }

}
