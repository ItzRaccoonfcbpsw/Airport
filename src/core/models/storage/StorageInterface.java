/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storage;

import java.util.ArrayList;

/**
 *
 * @author ISAIAS
 */
public interface StorageInterface<T> {
    
    public abstract boolean add(T data);
    public abstract T getById(int id);
    public abstract boolean delById(int id);
    public abstract ArrayList<T> getAll();
}
