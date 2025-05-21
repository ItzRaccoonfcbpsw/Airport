/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Location;
import core.models.Plane;
import core.models.storage.StorageFlight;
import core.models.storage.StorageLocation;
import core.models.storage.StoragePlane;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/**
 *
 * @author RYZEN
 */
public class FlightController {

    public static Response createflights(String id, String plane, String departureLocation, String scaleLocation, String arrivalLocation, String departureDate, String hoursDurationArrival, String minutesDurationArrival, String hoursDurationScale, String minutesDurationScale) {
        try {
            try {
                if (id.equals("")) {
                    return new Response("id must be not empty", Status.BAD_REQUEST);
                }
                if (!id.matches(("^[A-Z]{2}\\d{5}$"))) {
                    return new Response("The id has an invalid format", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Id must be numeric", Status.BAD_REQUEST);
            }
            StoragePlane airplaneStorage = StoragePlane.getInstance();
            Plane Planeplane = airplaneStorage.getPlane(plane);
            try {
                if (plane == null) {
                    return new Response("The airplane does not exist", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Id must be numeric", Status.BAD_REQUEST);
            }         
            StorageLocation locationStorage = StorageLocation.getInstance();
            Location departure = locationStorage.getLocation(departureLocation);
            Location arrival = locationStorage.getLocation(arrivalLocation);
            if (departure == null || arrival == null) {
                return new Response("Departure and arrival locations must exist", Status.BAD_REQUEST);
            }

            Location scale = null;
            if (!scaleLocation.equals("")) {
                scale = locationStorage.getLocation(scaleLocation);
                if (scale == null) {
                    return new Response("Scale location does not exist", Status.BAD_REQUEST);
                }
            }
            LocalDateTime DatedepartureLocation;
            try {
                DatedepartureLocation = LocalDateTime.parse(departureLocation);
            } catch (DateTimeParseException e) {
                return new Response("Departure date must be valid (format: yyyy-MM-ddTHH:mm)", Status.BAD_REQUEST);
            }

            int hArr, mArr, hScale, mScale;
            try {
                hArr = Integer.parseInt(hoursDurationArrival);
                mArr = Integer.parseInt(minutesDurationArrival);
                hScale = Integer.parseInt(hoursDurationScale);
                mScale = Integer.parseInt(minutesDurationScale);
            } catch (NumberFormatException e) {
                return new Response("Duration values must be numeric", Status.BAD_REQUEST);
            }

            // Validar que si no hay escala, la duración de escala sea 0
            if (scale == null && (hScale != 0 || mScale != 0)) {
                return new Response("If there is no scale location, scale time must be 0 hours and 0 minutes", Status.BAD_REQUEST);
            }

            // Validar que la duración total del vuelo sea mayor a 00:00
            int totalMinutes = hArr * 60 + mArr;
            if (totalMinutes <= 0) {
                return new Response("Arrival duration must be greater than 00:00", Status.BAD_REQUEST);
            }
            Flight flight;
            if (scale != null) {
                flight = new Flight(id, Planeplane, departure, scale, arrival, DatedepartureLocation, hArr, mArr, hScale, mScale);
            } else {
                flight = new Flight(id, Planeplane, departure, arrival, DatedepartureLocation, hArr, mArr);
            }
            StorageFlight flightStorage = StorageFlight.getInstance();
            if (flightStorage.getFlight(id) != null) {
                return new Response("A Plane with that id already exists", Status.BAD_REQUEST);
            }
            flightStorage.addFlight(flight);
            return new Response("Flight created successfully", Status.CREATED);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response delayFlight(String flightId, String delayTime) {
        try {
            // se valida ID
            if (flightId == null || flightId.isEmpty()) {
                return new Response("Flight ID must not be empty", Status.BAD_REQUEST);
            }
            // se valida el formato HH:MM
            if (delayTime == null || !delayTime.matches("^\\d{1,2}:\\d{2}$")) {
                return new Response("Invalid time format. Use HH:MM", Status.BAD_REQUEST);
            }
            String[] parts = delayTime.split(":");
            int hours, minutes;
            try {
                hours = Integer.parseInt(parts[0]);
                minutes = Integer.parseInt(parts[1]);

                if (hours < 0 || minutes < 0 || (hours == 0 && minutes == 0)) {
                    return new Response("Delay time must be greater than 00:00", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("Delay time must be numeric in HH:MM format", Status.BAD_REQUEST);
            }
            StorageFlight storage = StorageFlight.getInstance();
            Flight flight = storage.getFlight(flightId);
            if (flight == null) {
                return new Response("Flight not found", Status.NOT_FOUND);
            }
            // Aplicar el retraso
            flight.delay(hours, minutes);
            return new Response("Flight delayed successfully", Status.OK);

        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
