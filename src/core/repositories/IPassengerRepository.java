/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.repositories;

import core.models.Passenger;
import java.util.List;

public interface IPassengerRepository {
    void save(Passenger passenger);
    boolean existsById(long id);
    Passenger findById(long id);
    List<Passenger> findAllSorted();
}