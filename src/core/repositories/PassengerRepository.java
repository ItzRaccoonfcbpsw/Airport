/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.repositories;

import core.models.Passenger;
import core.observer.Observer;
import core.observer.Subject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class PassengerRepository implements IPassengerRepository, Subject {
    
    private final List<Passenger> passengers = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void save(Passenger passenger) {
        passengers.add(passenger);
        notifyObservers();
    }

    @Override
    public boolean existsById(long id) {
        return passengers.stream().anyMatch(p -> p.getId()== id);
    }
    
    @Override
    public Passenger findById(long id) {
        return passengers.stream()
                .filter(p -> p.getId()== id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Passenger> findAllSorted() {
        return passengers.stream()
                .sorted(Comparator.comparing(Passenger::getId))
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
    
    @Override
    public void deleteById(long id) {
        passengers.removeIf(p -> p.getId() == id);
        notifyObservers();
    }

    @Override
    public boolean update(Passenger updated) {
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getId() == updated.getId()) {
                passengers.set(i, updated);
                notifyObservers();
                return true;
            }
        }
        return false; // Not found
    }
}

