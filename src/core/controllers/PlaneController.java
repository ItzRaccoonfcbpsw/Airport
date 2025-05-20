/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Plane;
import core.models.storage.StoragePlane;

/**
 *
 * @author RYZEN
 */
public class PlaneController {
    
       public static Response createplanes(String id, String brand, String model, String maxCapacity, String airline) {
        try { 
            try {
                if (!id.matches(("^[A-Z]{2}\\d{5}$")))
                    return new Response("The id has an invalid format", Status.BAD_REQUEST);
            } catch (NumberFormatException ex) {
                return new Response("Id must be numeric", Status.BAD_REQUEST);
            }
            
            if (brand.equals("")) {
                return new Response("brand must be not empty", Status.BAD_REQUEST);
            }
            if (model.equals("")) {
                return new Response("model must be not empty", Status.BAD_REQUEST);
            }
            if (maxCapacity.equals("")) {
                return new Response("maxCapacity must be not empty", Status.BAD_REQUEST);
            }
            if (airline.equals("")) {
                return new Response("airline must be not empty", Status.BAD_REQUEST);
            }
                   
            StoragePlane storage = StoragePlane.getInstance();            
            if (!storage.addPlane(new Plane(id, brand, model, 0, airline))) {
                return new Response("A Plane with that id already exists", Status.BAD_REQUEST);
            }
            return new Response("Plane created successfully", Status.CREATED);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}

