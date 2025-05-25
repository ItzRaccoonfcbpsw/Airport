/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.repositories;

import core.models.Plane;
import core.observer.Observer;
import core.observer.Subject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlaneRepository implements IPlaneRepository, Subject {
    
    private final List<Plane> planes = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void save(Plane plane) {
        planes.add(plane);
        notifyObservers();
    }

    @Override
    public boolean existsById(String id) {
        return planes.stream().anyMatch(p -> p.getId().equals(id));
    }

    @Override
    public Plane findById(String id) {
        return planes.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<Plane> findAllSorted() {
        return planes.stream()
            .sorted(Comparator.comparing(Plane::getId))
            .toList();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this); // Enhanced observer with source
        }
    }
}