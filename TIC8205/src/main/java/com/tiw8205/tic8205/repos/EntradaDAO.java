package com.tiw8205.tic8205.repos;

import com.tiw8205.tic8205.mysql.entities.Entrada;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Clase de acceso a persistencia (DAO) para la clase Computer y que está basada en CrudRepository
 *
 * Un crud repository tiene una serie de métodos ya disponibles que permiten operar sobre entidades:
 * save( Entity) -> Hacer persistente una instancia de entidad en BBDD
 * findById()
 * findAll()
 * count()
 * delete(Entity) -> Eliminar de la base de datos..
 * exist...
 */

public interface EntradaDAO extends CrudRepository<Entrada, Integer> {

    // En el cuerpo de esta interfaz debemos incorporar todas las queries en forma de métodos que necesitemos realizar sobre nuestras tablas:
    // Hay 2 formas de autogenerar la implementación de los métodos que realizan queries en un CrudRepository:
    //  1) Especificar queries por nombrado (camelCase)  findByNombreAtributoAndNombreAtributo2( ...)
    //  2) Especificar queries explícitamente por JPQL
    // List<Usuarios> findAll();
    //Usuario findUsuarioByUsername(String username);
    //List<Entrada> findAll();
    List<Entrada> findAll();
    List<Entrada> findByPropietario(String propietario);
    List<Entrada> findByEvento(String evento);
    Entrada findByEventoAndPropietario(String evento, String propietario);
//  Ejemplo query por nombrado

//  List<Computer> findComputersByBrand(String brand);
//    // Especificar queries por JPQL (lo que va tras ':' es un parámetro que se reemplaza por los valores que pasemos al llamar al método)
//  @Query("SELECT c FROM Computer c WHERE c.brand=:brand")
// List<Computer> query1(String brand);


}