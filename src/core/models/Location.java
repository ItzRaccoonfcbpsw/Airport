/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

/**
 *
 * @author ISAIAS
 */
public class Location {
    private final String airportId;
    private String airportName;
    private String airportCity;
    private String airportCountry;
    private double airportLatitude;
    private double airportLongitude;

    @Override
    public String toString() {
        return "Location{" + "airportId=" + airportId + ", airportName=" + airportName + ", airportCity=" + airportCity + ", airportCountry=" + airportCountry + '}';
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportCity() {
        return airportCity;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    public String getAirportCountry() {
        return airportCountry;
    }

    public void setAirportCountry(String airportCountry) {
        this.airportCountry = airportCountry;
    }

    public double getAirportLatitude() {
        return airportLatitude;
    }

    public void setAirportLatitude(double airportLatitude) {
        this.airportLatitude = airportLatitude;
    }

    public double getAirportLongitude() {
        return airportLongitude;
    }

    public void setAirportLongitude(double airportLongitude) {
        this.airportLongitude = airportLongitude;
    }
    
    
}
