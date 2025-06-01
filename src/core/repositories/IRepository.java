/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.repositories;

import java.util.List;

public interface IRepository<T> {
    void save(T item);
    boolean existsById(String id);
    T findById(String id);
    List<T> findAllSorted();
}