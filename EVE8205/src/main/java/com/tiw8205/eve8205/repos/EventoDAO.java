package com.tiw8205.eve8205.repos;

import com.tiw8205.eve8205.mysql.entities.Evento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventoDAO extends CrudRepository<Evento, Integer> {

    List<Evento> findAll();
    Evento findByTitulo(String titulo);

}
