package core.controllers;

import core.utils.Response;
import core.utils.Status;
import core.models.Location;
import core.repositories.ILocationRepository;
import java.util.List;

public class LocationController {
    private final ILocationRepository repository;

    public LocationController(ILocationRepository repository) {
        this.repository = repository;
    }

    public Response registerLocation(String id, String name, String country, String city, double latitude, double longitude) {
        if (repository.existsById(id)) {
            return new Response("Location already exists", Status.BAD_REQUEST);
        }

        try {
            Location location = new Location(id, name, country, city, latitude, longitude);
            repository.save(location);
            return new Response("Location registered successfully", Status.CREATED, location);
        } catch (IllegalArgumentException e) {
            return new Response(e.getMessage(), Status.BAD_REQUEST);
        } catch (Exception e) {
            return new Response("Internal error: " + e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    public Response getAllLocations() {
    try {
        List<Location> planes = repository.findAllSorted();
        return new Response("Locations retrieved successfully", Status.OK, planes);
    } catch (Exception e) {
        return new Response("Error retrieving locations: " + e.getMessage(), Status.INTERNAL_SERVER_ERROR);
    }
    }
}
