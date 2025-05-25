/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.utils.Response;
import core.utils.Status;
import core.models.Plane;
import core.repositories.IPlaneRepository;
import java.util.List;

public class PlaneController {
    private final IPlaneRepository repository;

    public PlaneController(IPlaneRepository repository) {
        this.repository = repository;
    }

    public Response registerPlane(String id, String brand, String model, int maxCapacity, String airline) {
        if (repository.existsById(id)) {
            return new Response("Plane already exists", Status.BAD_REQUEST);
        }

        if (maxCapacity <= 0) {
            return new Response("Capacity must be greater than 0", Status.BAD_REQUEST);
        }

        try {
            Plane plane = new Plane(id, brand, model, maxCapacity, airline);
            repository.save(plane);
            return new Response("Plane registered successfully", Status.CREATED, plane);
        } catch (Exception e) {
            return new Response("Internal error: " + e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    public Response getAllPlanes() {
    try {
        List<Plane> planes = repository.findAllSorted();
        return new Response("Planes retrieved successfully", Status.OK, planes);
    } catch (Exception e) {
        return new Response("Error retrieving planes: " + e.getMessage(), Status.INTERNAL_SERVER_ERROR);
    }
}
}