package core.models;

import core.validator.Validator;

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
        
        if (!Validator.isValidCoordinates(airportLatitude, airportLongitude)) {
            throw new IllegalArgumentException("Invalid Coordinates");
        }
        
        if(!Validator.isValidAirportIdFormat(airportId)){
            throw new IllegalArgumentException("Invalid Airport ID");
        }

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
