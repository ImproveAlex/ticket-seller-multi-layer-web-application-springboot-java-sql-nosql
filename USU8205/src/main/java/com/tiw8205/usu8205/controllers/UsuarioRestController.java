package com.tiw8205.usu8205.controllers;

import com.tiw8205.usu8205.mysql.entities.Usuario;
import com.tiw8205.usu8205.repos.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class UsuarioRestController {

    static final String basePath = "/restful";
    // DAO object
    @Autowired
    UsuarioDAO userDAO;

    /*--------------*/
    /* METODOS CRUD */
    /*--------------*/

    // CREATE
    // Insertar datos de un usuario de la DB
    @RequestMapping(value = basePath + "/usuarios/post", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Usuario> insertUser(@RequestBody Usuario userAdd) {
        System.out.println("RESTFUL CONTROLLER::: Entering insertUser() method");
        try {
            userDAO.save(userAdd);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(userAdd, HttpStatus.OK);
    }

    // READ
    // Extraer datos de un usuario de la DB - GET by id
    @RequestMapping(value = basePath + "/usuarios/get/{username}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Usuario> getUser(@PathVariable String username) {
        System.out.println("RESTFUL CONTROLLER::: Entering getUser() method");
        Usuario retrievedUser = null;
        try {
            retrievedUser = userDAO.findByUsername(username);
            if (retrievedUser == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(retrievedUser, HttpStatus.OK);
    }

    // READ ALL
    // Extraer datos de todos los usuarios de la DB - GET ALL
    @RequestMapping(value = basePath + "/usuarios/get/all", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Usuario>> getAllUser() {
        System.out.println("RESTFUL CONTROLLER::: Entering getAllUser() method");
        List<Usuario> retrievedListUser;
        try {
            retrievedListUser = userDAO.findAll();
            if (retrievedListUser == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(retrievedListUser, HttpStatus.OK);
    }

    // UPDATE
    // Actualización de un usuario
    @RequestMapping(value = basePath + "/usuarios/put", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<Usuario> updateUser(@RequestBody Usuario toUpdate) {
        System.out.println("RESTFUL CONTROLLER::: Entering updateUser() method");
        Usuario updatedUser = null;
        //int intId = Integer.parseInt(id);
        try {
            // Buscamos por id y en caso de no encontrar nada, obtenemos null
            //Usuario dbUser = userDAO.findById(intId).orElse(null);
            Usuario dbUser = userDAO.findByUsername(toUpdate.getUsername());
            if (dbUser != null) {
                toUpdate.setId(dbUser.getId());
                userDAO.save(toUpdate);
                updatedUser = toUpdate;
            } else {
                return new ResponseEntity<>(updatedUser, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // DELETE
    // Eliminación de info en BBDD
    @RequestMapping(value = basePath + "/usuarios/delete/{username}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<Usuario> deleteOne(@PathVariable String username) {
        System.out.println("RESTFUL CONTROLLER::: Entering deleteOne() method");
        Usuario toDeleteUser = null;
        try {
            // Buscamos por id y en caso de no encontrar nada, obtenemos null
            toDeleteUser = userDAO.findByUsername(username);
            if (toDeleteUser == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            userDAO.delete(toDeleteUser);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
