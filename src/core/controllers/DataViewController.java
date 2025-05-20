/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.models.*;
import core.models.storage.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataViewController {

    // Pasajeros ordenados por ID
    public List<Passenger> getPassengersOrderedById() {
        return StoragePassenger.getInstance().getPassengers().stream().sorted(Comparator.comparingLong(Passenger::getId)).collect(Collectors.toList());
    }

    // Localizaciones ordenadas por ID
    public List<Location> getLocationsOrderedById() {
        return StorageLocation.getInstance().getLocations().stream().sorted(Comparator.comparing(Location::getAirportId)).collect(Collectors.toList());
    }

    // Aviones ordenados por ID
    public List<Plane> getPlanesOrderedById() {
        return StoragePlane.getInstance().getPlanes().stream().sorted(Comparator.comparing(Plane::getId)).collect(Collectors.toList());
    }

    // Vuelos ordenados por fecha de salida (más antiguos primero)
    public List<Flight> getFlightsOrderedByDeparture() {
        return StorageFlight.getInstance().getFlights().stream().sorted(Comparator.comparing(Flight::getDepartureDate)).collect(Collectors.toList());
    }

    // Vuelos de un pasajero ordenados por fecha de salida
    public List<Flight> getFlightsOfPassengerOrderedByDeparture(long passengerId) {
        Passenger passenger = StoragePassenger.getInstance().getPassenger(passengerId);
        if (passenger == null) {
            return new ArrayList<>();
        }
        return passenger.getFlights().stream().sorted(Comparator.comparing(Flight::getDepartureDate)).collect(Collectors.toList());
    }
}

