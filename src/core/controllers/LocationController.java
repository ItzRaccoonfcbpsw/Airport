/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Location;
import core.models.storage.StorageLocation;

/**
 *
 * @author RYZEN
 */
public class LocationController {
    public static Response createLocations(String airportId, String airportName, String airportCity, String airportCountry, String airportLatitude, String airportLongitude) {
        try { 
            double DoubleairportLatitude,DoubleairportLongitude; 
            try {
                if (!airportId.matches("^[A-Z]{3}$"))
                    return new Response("The id must only have 3 capital letters", Status.BAD_REQUEST);
            } catch (NumberFormatException ex) {
                return new Response("Id must be numeric", Status.BAD_REQUEST);
            }
            
            if (airportName.equals("")) {
                return new Response("airportName must be not empty", Status.BAD_REQUEST);
            }
            
            if (airportCity.equals("")) {
                return new Response("airportCity must be not empty", Status.BAD_REQUEST);
            }
            if (airportCountry.equals("")) {
                return new Response("airportCountry must be not empty", Status.BAD_REQUEST);
            }
          
            try {
                DoubleairportLatitude = Double.parseDouble(airportLatitude);
                if (DoubleairportLatitude < -90 || DoubleairportLatitude > 90) {
                    return new Response("Latitude must be between -90 and 90", Status.BAD_REQUEST);
                }
                if (!airportLatitude.matches("^-?\\d+(\\.\\d{1,4})?$")) {
                    return new Response("Latitude must have at most 4 decimal places", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Latitude must be a valid number", Status.BAD_REQUEST);
            }

            // Validar longitud
            try {
                DoubleairportLongitude = Double.parseDouble(airportLongitude);
                if (DoubleairportLongitude < -180 || DoubleairportLongitude > 180) {
                    return new Response("Longitude must be between -180 and 180", Status.BAD_REQUEST);
                }
                if (!airportLongitude.matches("^-?\\d+(\\.\\d{1,4})?$")) {
                    return new Response("Longitude must have at most 4 decimal places", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Longitude must be a valid number", Status.BAD_REQUEST);
            }
                        
            StorageLocation storage = StorageLocation.getInstance();            
            if (!storage.addLocation(new Location(airportId, airportName, airportCity, airportCountry, DoubleairportLatitude, DoubleairportLongitude))) {
                return new Response("A Location with that id already exists", Status.BAD_REQUEST);
            }
            return new Response("Location created successfully", Status.CREATED);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
