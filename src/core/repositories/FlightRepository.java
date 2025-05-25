/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.repositories;

import core.models.Flight;
import core.observer.Observer;
import core.observer.Subject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ISAIAS
 */
public class FlightRepository implements IFlightRepository, Subject{
    
  private final List<Flight> passengers = new ArrayList<>();
  private final List<Observer> observers = new ArrayList<>();

   @Override
    public void save(Flight flight) {
        passengers.add(flight);
        notifyObservers();
    }

    @Override
    public boolean existsById(String id) {
        return passengers.stream().anyMatch(p -> p.getId().equalsIgnoreCase(id));
    }
    
    @Override
    public Flight findById(String id) {
        return passengers.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Flight> findAllSorted() {
        return passengers.stream()
                .sorted(Comparator.comparing(Flight::getId))
                .toList();
    }

  
  @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }  
    
}
