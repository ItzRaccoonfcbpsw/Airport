/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Passenger;
import core.models.storage.StoragePassenger;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author ISAIAS
 */
public class PassengerController {

    public PassengerController(StoragePassenger storage) {
    }
    
    
    public static Response registerPassenger(long id, String firstname, String lastname, LocalDate birthDate, int countryPhoneCode, long phone, String country) {
        try { 
         Passenger p = new Passenger(id, firstname, lastname, birthDate, countryPhoneCode, phone, country);
            StoragePassenger storage = StoragePassenger.getInstance();            
            if (!storage.addPassenger(p)) {
                return new Response("A Passenger with that id already exists", Status.BAD_REQUEST);
            }
            storage.save(p);
            return new Response("Passenger created successfully", Status.CREATED);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

}
