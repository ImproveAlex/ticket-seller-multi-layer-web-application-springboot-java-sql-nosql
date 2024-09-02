package com.tiw8205.cha8205.repos;

import java.util.List;
import com.tiw8205.cha8205.mysql.entities.Mensaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MensajeDAO extends CrudRepository<Mensaje, Integer> {
    List<Mensaje> findAll();

    List<Mensaje> findByEmisorAndReceptor(String emisor, String receptor);

    List<Mensaje> findByEmisor(String emisor);

    List<Mensaje> findByMensajeLikeOrderByMensajeAsc(String expression);
}
