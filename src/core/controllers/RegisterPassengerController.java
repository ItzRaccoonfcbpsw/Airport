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
    
    
    public static Response registerPassenger(String id, String firstname, String lastname, String year, String month, String day, String countryPhoneCode, String phone, String country) {
        try { 
            long LongId, LongPhone;
            int IntcountryPhoneCode, Intyear, Intmonth, Intday;
            if (id.equals("")) {
                return new Response("id must be not empty", Status.BAD_REQUEST);
            }
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
            try {
                Intyear = Integer.parseInt(year);
                if (Intyear > 2025) {
                    return new Response("Year not valid", Status.BAD_REQUEST);
                }
                if(month.length() == 1 ){
                    month = "0"+month;                    
                }
                Intmonth = Integer.parseInt(month);
                if(day.length() == 1 ){
                    day = "0"+day;                    
                }
                Intday = Integer.parseInt(day);
            } catch (DateTimeParseException ex) {
                return new Response("Birthdate format must be yyyy-MM-dd", Status.BAD_REQUEST);
            }

             if (countryPhoneCode.equals("")) {
                return new Response("country Phone code must be not empty", Status.BAD_REQUEST);
            }
            try {
                IntcountryPhoneCode = Integer.parseInt(countryPhoneCode);
                if (IntcountryPhoneCode < 0)
                    return new Response("Country Phone Code must be greater than or equal to 0", Status.BAD_REQUEST);
                if (countryPhoneCode.length() > 3) {
                    return new Response("country Phone Code too long", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("country Phone Code must be numeric", Status.BAD_REQUEST);
            }
            if (phone.equals("")) {
                return new Response("phone must be not empty", Status.BAD_REQUEST);
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
            
             if (country.equals("")) {
                return new Response("Country must be not empty", Status.BAD_REQUEST);
            }
            StoragePassenger storage = StoragePassenger.getInstance();        
            LocalDate bitrhDate = LocalDate.parse(year + "-" + month + "-" + day);
            if (!storage.addPassenger(new Passenger(LongId, firstname, lastname, bitrhDate, IntcountryPhoneCode, LongPhone, country))) {
                return new Response("A Passenger with that id already exists", Status.BAD_REQUEST);
            }
            return new Response("Passenger created successfully", Status.CREATED);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
