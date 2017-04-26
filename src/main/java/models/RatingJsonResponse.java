package models;

/**
 * Created by luke_c on 26/04/2017.
 */
public class RatingJsonResponse {
    private String name;
    private String carType;
    private String supplier;
    private double rating;

    public RatingJsonResponse(Vehicle vehicle) {
        this.name = vehicle.getName();
        this.carType = vehicle.getSippDetails().getCarType();
        this.supplier = vehicle.getSupplier();
        this.rating = vehicle.getRating();
    }
}
