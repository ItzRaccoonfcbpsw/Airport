/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import core.models.Passenger;
import core.models.storage.JSONloader;
import core.models.storage.StoragePassenger;
import core.views.AirportFrame;



/**
 *
 * @author RYZEN
 */
public class Main {
    public static void main(String[] args) {
        
        AirportFrame ventana = new AirportFrame();
        ventana.setVisible(true);
        
        /*StoragePassenger storagepassenger = new StoragePassenger();
        JSONloader.loadPassengers("json/passengers.json", storagepassenger);
        Passenger p1 = storagepassenger.getPassenger(314747359);
        System.out.println(""+p1.getFullname());*/
       
        
        /*to do: ponerle las validaciones a los modelos como la del passenger, storage como en el passenger, en los storage no colocar observer por ahora, getAll de storage debe tener el ordenamiento, agregar los demas metodos del passenger, falta hacer el Json a los demas en el loader, y conectarlo a la vista, inicializarlas en el constructor, 
    }

    
}
