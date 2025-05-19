/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

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
}
