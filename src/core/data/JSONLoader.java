/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.data;

import core.models.*;
import core.repositories.IFlightRepository;
import core.repositories.ILocationRepository;
import core.repositories.IPassengerRepository;
import core.repositories.IPlaneRepository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ISAIAS
 */
public class JSONLoader {
    
    public static void loadPlanes(String path, IPlaneRepository repo) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            JSONArray array = new JSONArray(content);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                Plane plane = new Plane(
                    obj.getString("id"),
                    obj.getString("brand"),
                    obj.getString("model"),
                    obj.getInt("maxCapacity"),
                    obj.getString("airline")
                );
                repo.save(plane);
            }
        } catch (IOException e) {
            System.err.println("Failed to load planes: " + e.getMessage());
        }
    }

    public static void loadLocations(String path, ILocationRepository repo) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            JSONArray array = new JSONArray(content);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                Location location = new Location(
                    obj.getString("airportId"),
                    obj.getString("airportName"),
                    obj.getString("airportCountry"),
                    obj.getString("airportCity"),
                    obj.getDouble("airportLatitude"),
                    obj.getDouble("airportLongitude")
                );
                repo.save(location);
            }
        } catch (IOException e) {
            System.err.println("Failed to load locations: " + e.getMessage());
        }
    }
    
    public static void loadPassengers(String path, IPassengerRepository repo)
    {
        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            JSONArray array = new JSONArray(content);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                Passenger passenger = new Passenger(
                    obj.getLong("id"),
                    obj.getString("firstname"),
                    obj.getString("lastname"),
                    LocalDate.parse(obj.getString("birthDate")),
                    obj.getInt("countryPhoneCode"),
                    obj.getLong("phone"),
                    obj.getString("country")
                    
                );
                repo.save(passenger);
            }
        } catch (IOException e) {
            System.err.println("Failed to load passenger: " + e.getMessage());
        }
    }
    
    public static void loadFlights(String path, IFlightRepository flightRepo,
                               IPlaneRepository planeRepo,
                               ILocationRepository locationRepo) {
    try {
        String content = new String(Files.readAllBytes(Paths.get(path)));
        JSONArray array = new JSONArray(content);

        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);

            String id = obj.getString("id");
            String planeId = obj.getString("plane");
            String departureId = obj.getString("departureLocation");
            String arrivalId = obj.getString("arrivalLocation");
            String scaleId = obj.isNull("scaleLocation") ? null : obj.getString("scaleLocation");

            Plane plane = planeRepo.findById(planeId);
            Location departure = locationRepo.findById(departureId);
            Location arrival = locationRepo.findById(arrivalId);
            Location scale = (scaleId != null) ? locationRepo.findById(scaleId) : null;

            if (plane == null || departure == null || arrival == null) {
                System.err.println("Skipping flight " + id + ": unresolved references");
                continue;
            }

            LocalDateTime departureDate = LocalDateTime.parse(obj.getString("departureDate"));
            int hArr = obj.getInt("hoursDurationArrival");
            int mArr = obj.getInt("minutesDurationArrival");
            int hScale = obj.getInt("hoursDurationScale");
            int mScale = obj.getInt("minutesDurationScale");

            Flight flight = new Flight(id, plane, departure, scale, arrival, departureDate,
                                       hArr, mArr, hScale, mScale);

            flightRepo.save(flight);
        }
    } catch (IOException e) {
        System.err.println("Error loading flights: " + e.getMessage());
    }
}
    
}
