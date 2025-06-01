/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.validator;

import core.models.Flight;
import core.models.Location;
import core.models.Plane;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FormValidator {
    
    public static List<String> validatePassenger(String id, String firstname, String lastname,
                                                 String country, String phoneCode, String phone,
                                                 String year, String month, String day) {
        List<String> errors = new ArrayList<>();

        if (id == null || !id.matches("\\d+")) {
            errors.add("Passenger ID must be numeric.");
        }

        if (firstname == null || firstname.trim().isEmpty()) {
            errors.add("First name is required.");
        }

        if (lastname == null || lastname.trim().isEmpty()) {
            errors.add("Last name is required.");
        }

        if (country == null || country.length() < 2) {
            errors.add("Invalid country.");
        }

        if (phoneCode == null || !phoneCode.matches("\\d{1,4}")) {
            errors.add("Invalid phone code.");
        }

        if (phone == null || !phone.matches("\\d{7,10}")) {
            errors.add("Invalid phone number.");
        }

        try {
            int y = Integer.parseInt(year);
            int m = Integer.parseInt(month);
            int d = Integer.parseInt(day);
            LocalDate.of(y, m, d);
        } catch (Exception e) {
            errors.add("Invalid birth date.");
        }

        return errors;
    }

    public static List<String> validatePlane(String id, String brand, String model, String maxCapacity, String airline) {
        List<String> errors = new ArrayList<>();

        if (id == null || id.trim().isEmpty()) {
            errors.add("Plane ID is required.");
        }

        if (model == null || model.trim().isEmpty()) {
            errors.add("Model is required.");
        }
        
        if (brand == null || brand.trim().isEmpty()) {
            errors.add("Brand is required.");
        }
        
        if (airline == null || airline.trim().isEmpty()) {
            errors.add("Airline is required.");
        }

        try {
            int capacity = Integer.parseInt(maxCapacity);
            if (capacity <= 0) errors.add("Capacity must be greater than 0.");
        } catch (Exception e) {
            errors.add("Capacity must be a valid number.");
        }

        return errors;
    }

    public static List<String> validateLocation(String id, String name, String country, String latitudeStr, String longitudeStr) {
        List<String> errors = new ArrayList<>();

        if (id == null || id.isEmpty()) errors.add("Location ID is required.");
        if (name == null || name.isEmpty()) errors.add("Location name is required.");
        if (country == null || country.length() < 2) errors.add("Invalid country.");
        if (latitudeStr == null) errors.add("Invalid latitude.");
        if (longitudeStr == null) errors.add("Invalid longitude.");

        return errors;
    }

    public static List<String> validateFlight(String id, Plane plane, Location departure, Location arrival,
                                              LocalDate date) {
        List<String> errors = new ArrayList<>();
        if (id == null || id.isEmpty()) errors.add("Flight ID is required.");
        if (plane == null) errors.add("Plane is required.");
        if (departure == null || arrival == null) errors.add("Departure and arrival locations are required.");
        if (date == null) errors.add("Departure date is required.");
        return errors;
    }
    
}
