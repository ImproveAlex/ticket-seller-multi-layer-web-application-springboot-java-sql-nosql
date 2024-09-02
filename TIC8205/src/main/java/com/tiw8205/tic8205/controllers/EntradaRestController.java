package com.tiw8205.tic8205.controllers;

import com.tiw8205.tic8205.mysql.entities.Entrada;
import com.tiw8205.tic8205.repos.EntradaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class EntradaRestController {

    static final String basePath = "/restful";
    // DAO object
    @Autowired
    EntradaDAO ticketDAO;

    /*--------------*/
    /* METODOS CRUD */
    /*--------------*/

    // CREATE
    // Insertar datos de una entrada de la DB
    @RequestMapping(value = basePath + "/entradas/post", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Entrada> insertEntrada(@RequestBody Entrada ticketAdd) {

        /*
        if (userAdd == null) { // ->
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        */

        try {
            ticketDAO.save(ticketAdd);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(ticketAdd, HttpStatus.OK);
    }

    // READ
    // Extraer datos de una entrada de la DB - GET 
    @RequestMapping(value = basePath + "/entradas/get/owner/{propietario}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Entrada>> getTicketOwner(@PathVariable String propietario) {

        List<Entrada> retrievedList = null;
        try {
            retrievedList = ticketDAO.findByPropietario(propietario);
            if (retrievedList == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(retrievedList, HttpStatus.OK);
    }

    // READ
    // Extraer datos de una entrada de la DB - GET 
    @RequestMapping(value = basePath + "/entradas/get/event/{event}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Entrada>> getTicketEvent(@PathVariable String event) {

        List<Entrada> retrievedTicket = null;
        try {
            retrievedTicket = ticketDAO.findByEvento(event);
            if (retrievedTicket == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(retrievedTicket, HttpStatus.OK);
    }

    // READ ALL
    // Extraer datos de todas las entradas de la DB - GET ALL
    @RequestMapping(value = basePath + "/entradas/get/all", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Entrada>> getAllTicket() {
        List<Entrada> retrievedListTicket;
        try {
            retrievedListTicket = ticketDAO.findAll();
            if (retrievedListTicket == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(retrievedListTicket, HttpStatus.OK);
    }

    // UPDATE
    // Actualización de una entrada
    @RequestMapping(value = basePath + "/entradas/put", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<Entrada> updateEntrada(@RequestBody Entrada toUpdate) {
        Entrada updatedEntrada = null;
        try {
            // Buscamos por id y en caso de no encontrar nada, obtenemos null
            Entrada dbTicket = ticketDAO.findById(toUpdate.getId()).orElse(null);
            if (dbTicket != null) {
                toUpdate.setId(dbTicket.getId());
                ticketDAO.save(toUpdate);
                updatedEntrada = toUpdate;
            } else {
                return new ResponseEntity<>(updatedEntrada, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(updatedEntrada, HttpStatus.OK);
    }

    // DELETE
    // Eliminación de info en BBDD
    @RequestMapping(value = basePath + "/entradas/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<Entrada> deleteOne(@PathVariable String id) {
        Entrada toDeleteTicket = null;
        System.out.println("EL ID QUE RECIBIMOS ES: "+ id);
        try {
            int intid = Integer.parseInt(id);
            System.out.println("ID parseada a integer: " + intid);
            // Buscamos por id y en caso de no encontrar nada, obtenemos null
            toDeleteTicket = ticketDAO.findById(intid).orElse(null);
            if (toDeleteTicket == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            ticketDAO.delete(toDeleteTicket);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
