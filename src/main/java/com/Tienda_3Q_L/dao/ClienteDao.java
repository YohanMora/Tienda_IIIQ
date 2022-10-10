
package com.Tienda_3Q_L.dao;
import org.springframework.data.repository.CrudRepository;
import com.Tienda_3Q_L.domain.Cliente;

public interface ClienteDao extends CrudRepository<Cliente,Long> {
    
}
