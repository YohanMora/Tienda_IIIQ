/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda_3Q_L.controller;

import com.Tienda_3Q_L.domain.Categoria;
import com.Tienda_3Q_L.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Yohan Alvarado
 */
@Controller
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/categoria/listado")
    public String page(Model model) {
        var categorias = categoriaService.getCategorias(false);
     
        model.addAttribute("listaCategorias",categorias);
        
        return "/categoria/listado";
    }
    
    @GetMapping("/categoria/nuevoCategoria")
    public String nuevoCategoria(Categoria categoria) {
        
        return "/categoria/modificarCategoria";
    }
    
    @PostMapping("/categoria/guardarCategoria")
    public String guardarCategoria(Categoria categoria) {
        
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/categoria/modificarCategoria/{idCategoria}")
    public String modificarCategoria(Categoria categoria, Model model) {
        
        categoria = categoriaService.getCategoria(categoria);
        
        model.addAttribute("categoria",categoria);
        //categoriaService.save(categoria);
        return "/categoria/modificarCategoria";
    }
    
    @GetMapping("/categoria/eliminarCategoria/{idCategoria}")
    public String eliminarCategoria(Categoria categoria) {
        
        categoriaService.delete(categoria);
        
        return "redirect:/categoria/listado/";
    }
}
