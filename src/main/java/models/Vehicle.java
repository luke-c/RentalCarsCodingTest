package models;

/**
 * Created by luke_c on 25/04/2017.
 */
public class Vehicle {
    private String sipp;
    private Sipp sippDetails;
    private String name;
    private double price;
    private String supplier;
    private double rating;

    public Vehicle(String sipp, String name, double price, String supplier, double rating) {
        this.sipp = sipp;
        this.sippDetails = getSippDetails();
        this.name = name;
        this.price = price;
        this.supplier = supplier;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public Sipp getSippDetails() {
        if(sippDetails == null) {
            sippDetails = new Sipp(sipp);
        }
        return sippDetails;
    }

    public String getSipp() {
        return sipp;
    }

    public double getPrice() {
        return price;
    }

    public String getSupplier() {
        return supplier;
    }

    public double getRating() {
        return rating;
    }

    public int getVehicleScore() {
        int score = 0;
        score += getSippDetails().isAutomatic() ? 5 : 1;
        if(getSippDetails().hasAirCon()) score += 2;
        return score;
    }

    public double getSumOfScores() {
        return rating + getVehicleScore();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String separator = "} - {";

        builder.append("{");
        builder.append(name);
        builder.append(separator);
        builder.append(sipp);
        builder.append(separator);
        builder.append(getSippDetails().getCarType());
        builder.append(separator);
        builder.append(getSippDetails().getDoorCarType());
        builder.append(separator);
        builder.append(getSippDetails().isAutomatic() ? "Automatic" : "Manual");
        builder.append(separator);
        builder.append(getSippDetails().isPetrol() ? "Petrol" : "Not petrol");
        builder.append(separator);
        builder.append(getSippDetails().hasAirCon() ? "AC" : "no AC");
        builder.append("}");
        return builder.toString();
    }
}
