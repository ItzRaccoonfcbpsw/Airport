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
    
    
}
