/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;
import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 *
 * @author ISAIAS
 */
public class Flight {
    private final String id;
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private Location departureLocation;
    private Location scaleLocation;
    private Location arrivalLocation;
    private LocalDateTime departureDate;
    private int hoursDurationArrival;
    private int minutesDurationArrival;
    private int hoursDurationScale;
    private int minutesDurationScale;

    @Override
    public String toString() {
        return "Flight{" + "id=" + id + '}';
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Location getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(Location departureLocation) {
        this.departureLocation = departureLocation;
    }

    public Location getScaleLocation() {
        return scaleLocation;
    }

    public void setScaleLocation(Location scaleLocation) {
        this.scaleLocation = scaleLocation;
    }

    public Location getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(Location arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public int getHoursDurationArrival() {
        return hoursDurationArrival;
    }

    public void setHoursDurationArrival(int hoursDurationArrival) {
        this.hoursDurationArrival = hoursDurationArrival;
    }

    public int getMinutesDurationArrival() {
        return minutesDurationArrival;
    }

    public void setMinutesDurationArrival(int minutesDurationArrival) {
        this.minutesDurationArrival = minutesDurationArrival;
    }

    public int getHoursDurationScale() {
        return hoursDurationScale;
    }

    public void setHoursDurationScale(int hoursDurationScale) {
        this.hoursDurationScale = hoursDurationScale;
    }

    public int getMinutesDurationScale() {
        return minutesDurationScale;
    }

    public void setMinutesDurationScale(int minutesDurationScale) {
        this.minutesDurationScale = minutesDurationScale;
    }
    
    
}
