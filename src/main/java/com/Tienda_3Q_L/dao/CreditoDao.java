/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_3Q_L.dao;

import com.Tienda_3Q_L.domain.Credito;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Yohan Alvarado
 */
public interface CreditoDao extends CrudRepository<Credito,Long> {
    
}
