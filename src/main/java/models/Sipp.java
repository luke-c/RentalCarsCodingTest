package models;

import utils.SippUtils;

/**
 * Created by luke_c on 25/04/2017.
 */
public class Sipp {

    public String getCarType() {
        return carType;
    }

    public String getDoorCarType() {
        return doorCarType;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public boolean isPetrol() {
        return isPetrol;
    }

    public boolean hasAirCon() {
        return hasAirCon;
    }

    private String carType;
    private String doorCarType;
    private boolean isAutomatic;
    private boolean isPetrol;
    private boolean hasAirCon;

    public Sipp(String sipp) {
        if(sipp.length() != 4) {
            throw new IllegalArgumentException("A SIPP should have 4 characters, only " + sipp.length() + " characters found");
        }

        carType = SippUtils.CAR_TYPES.get(sipp.charAt(0));
        doorCarType = SippUtils.DOORS_CAR_TYPES.get(sipp.charAt(1));
        isAutomatic = SippUtils.isAutomatic(sipp.charAt(2));
        isPetrol = SippUtils.isPetrol(sipp.charAt(3));
        hasAirCon = SippUtils.hasAirCon(sipp.charAt(3));
    }

}
