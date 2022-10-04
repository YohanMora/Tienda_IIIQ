package com.Tienda_IIIQ.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.Tienda_IIIQ.domain.Cliente;
import java.util.Arrays;

/**
 *
 * @author Yohan Alvarado
 */

@Controller
public class IndexController {
    
    @Autowired
    private ClienteDao clienteDao;
    
    @GetMapping("/")
    public String page(Model model) {
        Cliente cliente = new Cliente("Yohan","Alvarado Mora","yalvarado@ufidelitas.ac.cr","82651234");
        //Cliente cliente2 = new Cliente("Maria","Flores Vargas","mflores@ufidelitas.ac.cr","87123456");
        //var listclientes = Arrays.asList(cliente,cliente2);
        var clientes = clienteDao.findAll();
        model.addAttribute("listaClientes",clientes);
        //model.addAttribute("cliente",cliente);
        return "index";
    }
    
}
