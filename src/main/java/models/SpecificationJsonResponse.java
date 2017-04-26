package models;

/**
 * Created by luke_c on 26/04/2017.
 */
public class SpecificationJsonResponse {
    private String name;
    private String sippName;
    private Sipp sipp;

    public SpecificationJsonResponse(Vehicle vehicle) {
        this.name = vehicle.getName();
        this.sippName = vehicle.getSipp();
        this.sipp = vehicle.getSippDetails();
    }
}
