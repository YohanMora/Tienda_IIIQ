/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_3Q_L.service;

import com.Tienda_3Q_L.domain.Articulo;
import java.util.List;

/**
 *
 * @author Yohan Alvarado
 */
public interface ArticuloService {
    
    public List<Articulo> getArticulos(boolean activos);
    
    public Articulo getArticulo(Articulo articulo);
    
    public void save(Articulo articulo);
    
    public void delete(Articulo articulo);
    
    public List<Articulo> getPorExistencias(int existencias);
    
    public List<Articulo> getPorExistenciasCategorias(int existencias, long idCategoria);
    
}
