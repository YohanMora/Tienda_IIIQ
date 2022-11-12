
package com.Tienda_3Q_L.dao;
import org.springframework.data.repository.CrudRepository;
import com.Tienda_3Q_L.domain.Cliente;
import java.util.List;

public interface ClienteDao extends CrudRepository<Cliente,Long> {
    List<Cliente> findByApellidos(String apellido);
}
