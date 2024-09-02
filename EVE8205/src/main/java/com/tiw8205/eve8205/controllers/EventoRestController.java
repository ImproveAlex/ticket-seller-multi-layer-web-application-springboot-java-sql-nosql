package com.tiw8205.eve8205.controllers;

import com.tiw8205.eve8205.mysql.entities.Evento;
import com.tiw8205.eve8205.repos.EventoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class EventoRestController {

    static final String basePath = "/restful";
    // DAO object
    @Autowired
    EventoDAO eventDAO;

    /*--------------*/
    /* METODOS CRUD */
    /*--------------*/

    // CREATE
    // Insertar datos de un evento de la DB

    @RequestMapping(value = basePath + "/eventos/post", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Evento> insertEvent(@RequestBody Evento eventAdd) {
        try {
            eventDAO.save(eventAdd);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(eventAdd, HttpStatus.OK);
    }



    // READ
    // Extraer datos de un evento de la DB - GET by titulo
    @RequestMapping(value = basePath + "/eventos/get/{titulo}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Evento> getEvento(@PathVariable String titulo) {
        System.out.println("RESTFUL CONTROLLER::: Entering getEvento() method");

        Evento retrievedEvent = null;
        try {
            retrievedEvent = eventDAO.findByTitulo(titulo);
            if (retrievedEvent == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println("\n\n Event retrieved: " + retrievedEvent.getTitulo() + "\n\n");
        return new ResponseEntity<>(retrievedEvent, HttpStatus.OK);
    }

    // READ ALL
    // Extraer datos de todos los eventos de la DB - GET ALL
    @RequestMapping(value = basePath + "/eventos/get/all", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Evento>> getAllEvents() {
        List<Evento> retrievedListEvent;
        try {
            retrievedListEvent = eventDAO.findAll();
            if (retrievedListEvent == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(retrievedListEvent, HttpStatus.OK);
    }

    // UPDATE
    // Actualización de un evento
    @RequestMapping(value = basePath + "/eventos/put", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<Evento> updateEvent(@RequestBody Evento toUpdate) {
        System.out.println("RESTFUL CONTROLLER::: Entering updateUser() method");
        Evento updatedEvent = null;
        //int intId = Integer.parseInt(id);
        try {
            // Buscamos por id y en caso de no encontrar nada, obtenemos null
            //Usuario dbUser = userDAO.findById(intId).orElse(null);
            Evento dbUser = eventDAO.findByTitulo(toUpdate.getTitulo());
            if (dbUser != null) {
                toUpdate.setId(dbUser.getId());
                eventDAO.save(toUpdate);
                updatedEvent = toUpdate;
            } else {
                return new ResponseEntity<>(updatedEvent, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }



    // DELETE
    // Eliminación de info en BBDD
    @RequestMapping(value = basePath + "/eventos/delete/{titulo}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<Evento> deleteOne(@PathVariable String titulo) {
        Evento toDeleteEvent = null;
        try {
            // Buscamos por titulo y en caso de no encontrar nada, obtenemos null
            toDeleteEvent = eventDAO.findByTitulo(titulo);
            if (toDeleteEvent == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            eventDAO.delete(toDeleteEvent);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }









}