package models;

/**
 * Created by luke_c on 26/04/2017.
 */
public class ScoreJsonResponse {
    private String name;
    private int vehicleScore;
    private double supplierRating;
    private double sumOfScores;

    public ScoreJsonResponse(Vehicle vehicle) {
        this.name = vehicle.getName();
        this.vehicleScore = vehicle.getVehicleScore();
        this.supplierRating = vehicle.getRating();
        this.sumOfScores = vehicle.getSumOfScores();
    }
}
