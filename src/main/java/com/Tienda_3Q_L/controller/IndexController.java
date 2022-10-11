package com.Tienda_3Q_L.controller;

import com.Tienda_3Q_L.domain.Cliente;
import com.Tienda_3Q_L.dao.ClienteDao;
import com.Tienda_3Q_L.service.ClienteService;
import com.Tienda_3Q_L.service.ClienteServiceImpl;
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
    private ClienteDao clienteDao;*/
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/")
    public String page(Model model) {
        var clientes = clienteService.getClientes();
     
        model.addAttribute("listaClientes",clientes);
        
        return "index";
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente) {
        
        return "modificarCliente";
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente) {
        
        clienteService.save(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        
        cliente = clienteService.getCliente(cliente);
        
        model.addAttribute("cliente",cliente);
        //clienteService.save(cliente);
        return "modificarCliente";
    }
    
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        
        clienteService.delete(cliente);
        
        return "redirect:/";
    }
}
