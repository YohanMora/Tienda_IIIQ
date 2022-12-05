/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda_3Q_L.controller;

import com.Tienda_3Q_L.domain.Cliente;
import com.Tienda_3Q_L.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Yohan Alvarado
 */
@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        var clientes=clienteService.getClientes();
        
        var limiteTotal=0;
        for (var c: clientes) {
            limiteTotal+=c.getCredito().getLimite();
        }
        model.addAttribute("limiteTotal",limiteTotal);
        model.addAttribute("totalClientes",clientes.size());
        
        model.addAttribute("clientes",clientes);
        return "/cliente/listado";
    }

    @GetMapping("/cliente/nuevoCliente")
    public String nuevoCliente(Cliente cliente) {

        return "/cliente/modificarCliente";
    }

    @PostMapping("/cliente/guardarCliente")
    public String guardarCliente(Cliente cliente) {

        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/cliente/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {

        cliente = clienteService.getCliente(cliente);

        model.addAttribute("cliente", cliente);
        //clienteService.save(cliente);
        return "/cliente/modificarCliente";
    }

    @GetMapping("/cliente/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente) {

        clienteService.delete(cliente);

        return "redirect:/cliente/listado/";
    }

    @GetMapping("/cliente/busquedaApellido")
    public String busquedaApellido(Model model, Cliente cliente) {
        model.addAttribute("cliente", cliente);
        return "/cliente/busquedaApellidos";
    }

    @PostMapping("/cliente/buscarCliente")
    public String buscarCliente(Model model, Cliente cliente) {

        var clientes = clienteService.getClientePorApellido(cliente.getApellidos());
        model.addAttribute("listaClientes", clientes);
        model.addAttribute("cliente", cliente);
        return "/cliente/busquedaApellidos";
    }
}
