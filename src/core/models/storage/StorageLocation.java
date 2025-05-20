/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storage;
import core.models.Location;
import core.models.Passenger;
import java.util.ArrayList;

/**
 *
 * @author RYZEN
 */
public class StorageLocation {
      // Instancia Singleton
    private static StorageLocation instance;
    
    // Atributos del StoragePassenger
    private ArrayList<Location> locations;
    
    private StorageLocation () {
        this.locations = new ArrayList<>();
    }
    
    public static StorageLocation getInstance() {
        if (instance == null) {
            instance = new StorageLocation();
        }
        return instance;
    }
    
    public boolean addLocation(Location location) {
        for (Location l : this.locations) {
            if (l.getAirportId().equals(location.getAirportId())) {
                return false;
            }
        }
        this.locations.add(location);
        return true;
    }
    
    public Location getLocation(String id) {
        for (Location location : this.locations) {
            if (location.getAirportId().equals(id)) {
                return location;
            }
        }
        return null;
    }
    
    public boolean delLocation(String id) {
        for (Location location : this.locations) {
            if (location.getAirportId().equals(id)) {
                this.locations.remove(location);
                return true;
            }
        }
        return false;
    }
}


