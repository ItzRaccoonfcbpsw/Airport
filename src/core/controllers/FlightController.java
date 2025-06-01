/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.utils.Response;
import core.utils.Status;
import core.models.Flight;
import core.models.Location;
import core.models.Plane;
import core.repositories.IFlightRepository;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author ISAIAS
 */
public class FlightController {
    
     private final IFlightRepository repository;
     
      public FlightController(IFlightRepository repository) {
        this.repository = repository;
    }
      
    public Response registerFlight(String id, Plane plane, Location departureLocation, Location arrivalLocation, LocalDateTime departureDate, int hoursDurationArrival, int minutesDurationArrival) {
        if (repository.existsById(id)) {
            return new Response("Flight already exists", Status.BAD_REQUEST);
        }
        
        try { 
         Flight f = new Flight(id, plane, departureLocation, arrivalLocation, departureDate, hoursDurationArrival, minutesDurationArrival);
                       
            repository.save(f);
            return new Response("Flight created successfully", Status.CREATED, f);
        } catch (IllegalArgumentException e) {
            return new Response(e.getMessage(), Status.BAD_REQUEST);
        } catch (Exception e) {
            return new Response("Internal error: " + e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    public Response registerFlight(String id, Plane plane, Location departureLocation, Location scaleLocation, Location arrivalLocation, LocalDateTime departureDate, int hoursDurationArrival, int minutesDurationArrival, int hoursDurationScale, int minutesDurationScale) {
        if (repository.existsById(id)) {
            return new Response("Flight already exists", Status.BAD_REQUEST);
        }
        
        try { 
         Flight f = new Flight(id, plane, departureLocation, scaleLocation, arrivalLocation, departureDate, hoursDurationArrival, minutesDurationArrival, hoursDurationScale, minutesDurationScale);
                       
            repository.save(f);
            return new Response("Flight created successfully", Status.CREATED, f);
        } catch (IllegalArgumentException e) {
            return new Response(e.getMessage(), Status.BAD_REQUEST);
        } catch (Exception e) {
            return new Response("Internal error: " + e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    public Response getAllFlights() {
        try {
            List<Flight> flights = repository.findAllSorted();
            return new Response("Flights retrieved successfully", Status.OK, flights);
        } catch (Exception e) {
            return new Response("Error retrieving flights: " + e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
    
}
