package core.models;

public class Location {
    private final String airportId;
    private final String airportName;
    private final String airportCountry;
    private final String airportCity;
    private final double airportLatitude;
    private final double airportLongitude;

    public Location(String airportId, 
                    String airportName, 
                    String airportCountry, 
                    String airportCity, 
                    double airportLatitude, 
                    double airportLongitude) {
        if (airportId == null || airportId.isEmpty()) throw new IllegalArgumentException("Invalid ID");
        if (airportName == null || airportName.isEmpty()) throw new IllegalArgumentException("Invalid name");
        if (airportCountry == null || airportCountry.isEmpty()) throw new IllegalArgumentException("Invalid country");
        if (airportCity == null || airportCity.isEmpty()) throw new IllegalArgumentException("Invalid country");
        if (airportLatitude < -90 || airportLatitude > 90) throw new IllegalArgumentException("Invalid latitude");
        if (airportLongitude < -180 || airportLongitude > 180) throw new IllegalArgumentException("Invalid longitude");

        this.airportId = airportId;
        this.airportName = airportName;
        this.airportCountry = airportCountry;
        this.airportCity = airportCity;
        this.airportLatitude = airportLatitude;
        this.airportLongitude = airportLongitude;
    }

    public String getAirportId() {
        return airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getAirportCountry() {
        return airportCountry;
    }

    public String getAirportCity() {
        return airportCity;
    }

    public double getLatitude() {
        return airportLatitude;
    }

    public double getLongitude() {
        return airportLongitude;
    }
    
    
}
