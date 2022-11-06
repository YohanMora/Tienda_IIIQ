package com.Tienda_3Q_L.controller;

import com.Tienda_3Q_L.domain.Articulo;
import com.Tienda_3Q_L.dao.ArticuloDao;
import com.Tienda_3Q_L.service.ArticuloService;
import com.Tienda_3Q_L.service.ArticuloServiceImpl;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IndexController {
    /*@Autowired
    private ArticuloDao articuloDao;*/
    @Autowired
    private ArticuloService articuloService;
    @GetMapping("/")
    public String page(Model model) {
        var articulos = articuloService.getArticulos(true);
     
        model.addAttribute("listaArticulos",articulos);
        
        return "index";
    }
    
    
}
