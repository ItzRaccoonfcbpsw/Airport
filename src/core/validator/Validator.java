/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.validator;
import java.time.LocalDate;
/**
 *
 * @author ISAIAS
 */
public class Validator {

    public static boolean isValidPassengerId(long id) {
        return id >= 0 && String.valueOf(id).length()<=15;
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidDate(LocalDate date) {
        return date != null && date.isBefore(LocalDate.now());
    }

    public static boolean isValidPhoneCode(int code) {
        return code >= 0 && String.valueOf(code).length()<=3;
    }

    public static boolean isValidPhone(long phone) {
        return phone >= 0 && String.valueOf(phone).length()<=11;
    }

    public static boolean isValidPlaneIdFormat(String planeId) {
        return planeId != null && planeId.matches("^[A-Z]{2}[0-9]{5}$");
    }
    
    public static boolean isValidCoordinates(double latitude, double longitude) {
        
        if (latitude < -90 || latitude > 90) return false;
        if (longitude < -180 || longitude > 180) return false;
        
        return hasMaxFourDecimalPlaces(latitude) && hasMaxFourDecimalPlaces(longitude);
    }
 
    private static boolean hasMaxFourDecimalPlaces(double value) {
        String[] parts = String.valueOf(value).split("\\.");
        return parts.length == 1 || parts[1].length() <= 4;
    }
    
    public static boolean isValidAirportIdFormat(String id) {
        return id != null && id.matches("^[A-Z]{3}$");
    }

}
