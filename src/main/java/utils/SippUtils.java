package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luke_c on 25/04/2017.
 */
public class SippUtils {
    public static final Map<Character, String> CAR_TYPES = getCarTypes();
    public static final Map<Character, String> DOORS_CAR_TYPES = getDoorsCarTypes();

    // Constructs the HashMap containing Car Types
    private static Map<Character, String> getCarTypes() {
        Map<Character, String> carTypeMap = new HashMap<>();
        carTypeMap.put('M', "Mini");
        carTypeMap.put('E', "Economy");
        carTypeMap.put('C', "Compact");
        carTypeMap.put('I', "Intermediate");
        carTypeMap.put('S', "Standard");
        carTypeMap.put('F', "Full size");
        carTypeMap.put('P', "Premium");
        carTypeMap.put('L', "Luxury");
        carTypeMap.put('X', "Special");
        return carTypeMap;
    }

    // Constructs the HashMap containing Doors / Car Types
    private static Map<Character, String> getDoorsCarTypes() {
        Map<Character, String> doorsCarTypeMap = new HashMap<>();
        doorsCarTypeMap.put('B', "2 doors");
        doorsCarTypeMap.put('C', "4 doors");
        doorsCarTypeMap.put('D', "5 doors");
        doorsCarTypeMap.put('W', "Estate");
        doorsCarTypeMap.put('T', "Convertible");
        doorsCarTypeMap.put('F', "SUV");
        doorsCarTypeMap.put('P', "Pick up");
        doorsCarTypeMap.put('V', "Passenger Van");
        return doorsCarTypeMap;
    }

    // Checks whether a Vehicle has automatic transmission based on the SIPP character
    public static boolean isAutomatic(char character) {
        switch (character) {
            case 'M':
                return false;
            case 'A':
                return true;
            default:
                throw new IllegalArgumentException("Invalid character");
        }
    }

    // Checks whether a Vehicle uses petrol based on the SIPP character
    public static boolean isPetrol(char character) {
        switch (character) {
            case 'N':
                return true;
            case 'R':
                return true;
            default:
                throw new IllegalArgumentException("Invalid character");
        }
    }

    // Checks whether a Vehicle has air conditioning based on the SIPP character
    public static boolean hasAirCon(char character) {
        switch (character) {
            case 'N':
                return false;
            case 'R':
                return true;
            default:
                throw new IllegalArgumentException("Invalid character");
        }
    }
}
