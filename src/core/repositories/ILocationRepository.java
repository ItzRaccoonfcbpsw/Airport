/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.repositories;

import core.models.Location;
import java.util.List;

public interface ILocationRepository {
    void save(Location location);
    boolean existsById(String id);
    Location findById(String id);
    List<Location> findAllSorted();
}