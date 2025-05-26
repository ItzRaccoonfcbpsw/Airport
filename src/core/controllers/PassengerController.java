/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.utils.Response;
import core.utils.Status;
import core.models.Passenger;
import core.repositories.IPassengerRepository;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ISAIAS
 */
public class PassengerController {

    private final IPassengerRepository repository;
    
    
    public PassengerController(IPassengerRepository repository) {
        this.repository = repository;
    }
    
    
    public Response registerPassenger(long id, String firstname, String lastname, LocalDate birthDate, int countryPhoneCode, long phone, String country) {
        if (repository.existsById(id)) {
            return new Response("Passenger already exists", Status.BAD_REQUEST);
        }
        
        try { 
         Passenger p = new Passenger(id, firstname, lastname, birthDate, countryPhoneCode, phone, country);
                       
            repository.save(p);
            return new Response("Passenger created successfully", Status.CREATED, p);
        } catch (IllegalArgumentException e) {
            return new Response(e.getMessage(), Status.BAD_REQUEST);
        } catch (Exception e) {
            return new Response("Internal error: " + e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    public Response getPassengerById(long id)
    {
       
       Passenger passenger = repository.findById(id);
       
       if(passenger == null) return new Response("Error retrieving passenger: " , Status.INTERNAL_SERVER_ERROR);
           
       return new Response("Passengers retrieved successfully", Status.OK, passenger);
    }
    
    public Response getAllPassengers() {
    try {
        List<Passenger> passengers = repository.findAllSorted();
        return new Response("Passengers retrieved successfully", Status.OK, passengers);
    } catch (Exception e) {
        return new Response("Error retrieving passengers: " + e.getMessage(), Status.INTERNAL_SERVER_ERROR);
    }
    }

    public Response deletePassengerById(long id) {
        if (!repository.existsById(id)) {
            return new Response("Passenger not found.", Status.NOT_FOUND);
        }

        repository.deleteById(id);
        return new Response("Passenger deleted successfully.", Status.OK);
    }

    public Response updatePassenger(Passenger updatedPassenger) {
    if (!repository.existsById(updatedPassenger.getId())) {
        return new Response("Passenger not found.", Status.NOT_FOUND);
    }

    boolean success = repository.update(updatedPassenger);
        if (success) {
            return new Response("Passenger updated successfully.", Status.OK, updatedPassenger);
        } else {
            return new Response("Error updating passenger.", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
