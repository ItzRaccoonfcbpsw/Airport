/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ISAIAS
 */
public class Passenger {
    private final long id;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private int countryPhoneCode;
    private long phone;
    private String country;
    private ArrayList<Flight> flights;

    @Override
    public String toString() {
        return "Passenger{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", countryPhoneCode=" + countryPhoneCode + ", country=" + country + '}';
    }
    
    
}
