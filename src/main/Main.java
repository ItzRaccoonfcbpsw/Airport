package main;
        
import core.controllers.FlightController;
import core.controllers.LocationController;
import core.controllers.PassengerController;
import core.controllers.PlaneController;
import core.repositories.FlightRepository;
import core.repositories.IFlightRepository;
import core.repositories.ILocationRepository;
import core.repositories.LocationRepository;
import core.repositories.IPassengerRepository;
import core.repositories.IPlaneRepository;
import core.repositories.NuevoFlightRepository;
import core.repositories.PassengerRepository;
import core.repositories.PlaneRepository;
import core.views.AirportFrame;
import core.data.JSONLoader;

public class Main {
    public static void main(String[] args) {
        
        ILocationRepository locationRepo = new LocationRepository();
        LocationController locationController = new LocationController(locationRepo);
        
        IPlaneRepository planeRepo = new PlaneRepository();
        PlaneController planeController = new PlaneController(planeRepo);
        
        IPassengerRepository passengerRepo = new PassengerRepository();
        PassengerController passengerController = new PassengerController(passengerRepo);

        IFlightRepository flightRepo = new FlightRepository();
        FlightController flightController = new FlightController(flightRepo);
        
        
        IFlightRepository nuevoFlightRepo = new NuevoFlightRepository();
        
        flightController = new FlightController(nuevoFlightRepo);
        
         AirportFrame ventana = new AirportFrame(locationController, planeController, passengerController, flightController);
         
         ((LocationRepository)locationRepo).addObserver(ventana);
         ((PlaneRepository)planeRepo).addObserver(ventana);
         ((PassengerRepository)passengerRepo).addObserver(ventana);
         ((FlightRepository)flightRepo).addObserver(ventana);
        
         
        JSONLoader.loadLocations("json/locations.json", locationRepo);
        JSONLoader.loadPlanes("json/planes.json", planeRepo);
        JSONLoader.loadPassengers("json/passengers.json", passengerRepo);
        JSONLoader.loadFlights("json/flights.json", flightRepo, planeRepo, locationRepo);
        
        
        System.out.println("Location system initialized!");
        System.out.println("Plane system initialized!");
        System.out.println(locationRepo.findById("JFK").getAirportName());
        System.out.println(planeRepo.findById("AB12345").getBrand());
        
        
        ventana.setVisible(true);


    }
}
