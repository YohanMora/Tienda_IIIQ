package com.Tienda_IIIQ.domain;

import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author Yohan Alvarado
 */
@Data
@Entity
@Table(name="cliente")
public class Cliente {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.Identity)
    private Long idCliente;
    String nombre;
    String apellidos;
    String correo;
    String telefono;
    
    public Cliente(String nombre, String apellidos, String correo, String telefono){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }
    
}
