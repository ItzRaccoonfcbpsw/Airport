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
 * @author RYZEN
 */
public class RegisterPassengerController {
    
    
    public static Response registerPassenger(String id, String firstname, String lastname, String birthDate, String countryPhoneCode, String phone, String country) {
        try { 
            long LongId, LongPhone;
            int IntcountryPhoneCode;
            LocalDate DatebirthDate;
            try {
                LongId = Long.parseLong(id);
                if (LongId < 0)
                    return new Response("ID must be greater than or equal to 0", Status.BAD_REQUEST);
                if (id.length() > 15) {
                    return new Response("ID too long", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Id must be numeric", Status.BAD_REQUEST);
            }
            
            if (firstname.equals("")) {
                return new Response("Firstname must be not empty", Status.BAD_REQUEST);
            }
            
            if (lastname.equals("")) {
                return new Response("Lastname must be not empty", Status.BAD_REQUEST);
            }
            if (country.equals("")) {
                return new Response("Country must be not empty", Status.BAD_REQUEST);
            }
            try {
                DatebirthDate = LocalDate.parse(birthDate);
                if (DatebirthDate.isAfter(LocalDate.now())) {
                    return new Response("The date of birth must be before the current date", Status.BAD_REQUEST);
                }
            } catch (DateTimeParseException ex) {
                return new Response("Birthdate format must be yyyy-MM-dd", Status.BAD_REQUEST);
            }
            try {
                IntcountryPhoneCode = Integer.parseInt(countryPhoneCode);
                if (IntcountryPhoneCode < 0)
                    return new Response("CountryPhoneCode must be greater than or equal to 0", Status.BAD_REQUEST);
                if (countryPhoneCode.length() > 3) {
                    return new Response("countryPhoneCode too long", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("countryPhoneCode must be numeric", Status.BAD_REQUEST);
            }
            try {
                LongPhone = Long.parseLong(phone);
                if (LongPhone < 0)
                    return new Response("Phone must be greater than or equal to 0", Status.BAD_REQUEST);
                if (phone.length() > 11) {
                    return new Response("Phone too long", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Phone must be numeric", Status.BAD_REQUEST);
            }
            StoragePassenger storage = StoragePassenger.getInstance();            
            if (!storage.addPassenger(new Passenger(LongId, firstname, lastname, DatebirthDate, IntcountryPhoneCode, LongPhone, country))) {
                return new Response("A Passenger with that id already exists", Status.BAD_REQUEST);
            }
            return new Response("Passenger created successfully", Status.CREATED);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
