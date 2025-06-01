/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.repositories;

import core.models.Flight;
import java.util.List;

/**
 *
 * @author ISAIAS
 */
public interface IFlightRepository {
    void save(Flight flight);
    boolean existsById(String id);
    Flight findById(String id);
    List<Flight> findAllSorted();
}
