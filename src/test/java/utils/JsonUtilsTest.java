package utils;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by luke_c on 26/04/2017.
 */
public class JsonUtilsTest {

    @Test
    public void testGetVehicleList() {
        // There should be 31 vehicles
        assertTrue(JsonUtils.getVehicleList().size() == 31);
    }
}
