/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_3Q_L.dao;

import com.Tienda_3Q_L.domain.Articulo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Yohan Alvarado
 */
public interface ArticuloDao extends CrudRepository<Articulo,Long> {
    
    List<Articulo> findByExistencias(int existencias);
    List<Articulo> findByExistenciasOrIdCategoria(int existencias, long idCategoria);
    //List<Articulo> findByExistenciasOrIdCategoria(int existencias, long idCategoria);
    
}
