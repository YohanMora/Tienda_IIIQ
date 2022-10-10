package com.Tienda_3Q_L.controller;

import com.Tienda_3Q_L.domain.Cliente;
import com.Tienda_3Q_L.dao.ClienteDao;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Controller
public class IndexController {
    @Autowired
    private ClienteDao clienteDao;
    @GetMapping("/")
    public String page(Model model) {
        Cliente cliente = new Cliente("Yohan","Alvarado Mora","yalvarado@ufidelitas.ac.cr","82651234");
        Cliente cliente2 = new Cliente("Maria","Flores Vargas","mflores@ufidelitas.ac.cr","87123456");
        var listclientes = Arrays.asList(cliente,cliente2);
        var clientes = clienteDao.findAll();
        model.addAttribute("cliente",cliente);
        model.addAttribute("listaClientes",clientes);
        
        return "index";
    }
    
}
