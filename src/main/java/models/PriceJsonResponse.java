package models;

/**
 * Created by luke_c on 26/04/2017.
 */
public class PriceJsonResponse {
    private String name;
    private Double price;

    public PriceJsonResponse(Vehicle vehicle) {
        this.name = vehicle.getName();
        this.price = vehicle.getPrice();
    }
}
