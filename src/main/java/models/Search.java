package models;

import java.util.List;

/**
 * Created by luke_c on 25/04/2017.
 */
public class Search {
    public List<Vehicle> getVehicleList() {
        return VehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.VehicleList = vehicleList;
    }

    private List<Vehicle> VehicleList;
}
