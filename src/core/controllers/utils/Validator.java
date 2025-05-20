/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils;
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


}
