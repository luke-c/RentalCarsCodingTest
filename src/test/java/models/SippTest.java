package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by luke_c on 26/04/2017.
 */
public class SippTest {

    @Test
    public void testSipp() {
        Sipp sippManualAircon = new Sipp("CXMR");
        assertEquals("Compact", sippManualAircon.getCarType());
        assertEquals(null, sippManualAircon.getDoorCarType());
        assertFalse(sippManualAircon.isAutomatic());
        assertTrue(sippManualAircon.hasAirCon());
        assertTrue(sippManualAircon.isPetrol());

        Sipp sippManualNoAircon = new Sipp("MBMN");
        assertEquals("Mini", sippManualNoAircon.getCarType());
        assertEquals("2 doors", sippManualNoAircon.getDoorCarType());
        assertFalse(sippManualNoAircon.isAutomatic());
        assertFalse(sippManualNoAircon.hasAirCon());
        assertTrue(sippManualNoAircon.isPetrol());

        Sipp sippAutomatic = new Sipp("CCAR");
        assertEquals("Compact", sippAutomatic.getCarType());
        assertEquals("4 doors", sippAutomatic.getDoorCarType());
        assertTrue(sippAutomatic.isAutomatic());
        assertTrue(sippAutomatic.hasAirCon());
        assertTrue(sippAutomatic.isPetrol());
    }

}
