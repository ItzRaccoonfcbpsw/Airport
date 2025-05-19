/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import java.util.ArrayList;

/**
 *
 * @author ISAIAS
 */
public class Plane {
    private final String id;
    private String brand;
    private String model;
    private final int maxCapacity;
    private String airline;
    private ArrayList<Flight> flights;

    @Override
    public String toString() {
        return "Plane{" + "id=" + id + ", brand=" + brand + ", model=" + model + ", airline=" + airline + '}';
    }
    
    
}
