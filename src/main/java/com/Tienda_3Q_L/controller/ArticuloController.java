/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda_3Q_L.controller;

import com.Tienda_3Q_L.domain.Articulo;
import com.Tienda_3Q_L.service.ArticuloService;
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
public class ArticuloController {
    
    @Autowired
    private ArticuloService articuloService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/articulo/listado")
    public String page(Model model) {
        var articulos = articuloService.getArticulos(false);
     
        model.addAttribute("listaArticulos",articulos);
        
        return "/articulo/listado";
    }
    
    @GetMapping("/articulo/nuevoArticulo")
    public String nuevoArticulo(Articulo articulo, Model model) {
        var listCategorias = categoriaService.getCategorias(true);
        model.addAttribute("listCategorias",listCategorias);
        return "/articulo/modificarArticulo";
    }
    
    @PostMapping("/articulo/guardarArticulo")
    public String guardarArticulo(Articulo articulo) {
        
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }
    
    @GetMapping("/articulo/modificarArticulo/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
        
        articulo = articuloService.getArticulo(articulo);
        var listCategorias = categoriaService.getCategorias(true);
        model.addAttribute("listCategorias",listCategorias);
        model.addAttribute("articulo",articulo);
        //articuloService.save(articulo);
        return "/articulo/modificarArticulo";
    }
    
    @GetMapping("/articulo/eliminarArticulo/{idArticulo}")
    public String eliminarArticulo(Articulo articulo) {
        
        articuloService.delete(articulo);
        
        return "redirect:/articulo/listado/";
    }
}
