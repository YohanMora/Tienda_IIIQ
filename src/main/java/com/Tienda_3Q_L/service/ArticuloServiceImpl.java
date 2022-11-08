/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_3Q_L.service;

import com.Tienda_3Q_L.dao.ArticuloDao;
import com.Tienda_3Q_L.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Yohan Alvarado
 */
@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private ArticuloDao articuloDao;

    @Override
    @Transactional(readOnly=true)
    public List<Articulo> getArticulos(boolean activos) {
        var list = (List<Articulo>)articuloDao.findAll();
        
        if(activos){
         list.removeIf(e -> !e.isActivo());
        }
        
        return list;
    }

    @Override
    @Transactional(readOnly=true)
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
    }

    @Override
    public List<Articulo> getPorExistencias(int existencias) {
        return articuloDao.findByExistencias(existencias);
    }

    @Override
    public List<Articulo> getPorExistenciasCategorias(int existencias, long idCategoria) {
        return articuloDao.findByExistenciasOrIdCategoria(existencias, idCategoria); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
