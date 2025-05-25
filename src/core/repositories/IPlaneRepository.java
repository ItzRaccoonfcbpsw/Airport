/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.repositories;

import core.models.Plane;
import java.util.List;


public interface IPlaneRepository {
     void save(Plane plane);
    boolean existsById(String id);
    Plane findById(String id);
    List<Plane> findAllSorted();
}
