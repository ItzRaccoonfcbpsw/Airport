package core.repositories;

import core.models.Location;
import core.observer.Observer;
import core.observer.Subject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LocationRepository implements ILocationRepository, Subject {
    
    private final List<Location> locations = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void save(Location location) {
        locations.add(location);
        notifyObservers();
    }

    @Override
    public boolean existsById(String id) {
        return locations.stream().anyMatch(l -> l.getAirportId().equals(id));
    }

    @Override
    public Location findById(String id) {
        return locations.stream()
                .filter(l -> l.getAirportId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Location> findAllSorted() {
        return locations.stream()
                .sorted(Comparator.comparing(Location::getAirportId))
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
