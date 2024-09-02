package com.tiw8205.usu8205.controllers;

import com.tiw8205.usu8205.mysql.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Controller
public class UsuarioApiConsumer {

    @Autowired
    RestTemplate restTemplate;

    //PETICION TIPO GET
    @RequestMapping(value = "/api-consumer/get", method = RequestMethod.GET)
    public @ResponseBody
    String getUserByCallingApi() {
        System.out.println("Llega al GET en API CONSUMER");
        int userId = 1; // -> Por ejemplo buscamos este usuario
        Usuario user =
                restTemplate.getForObject("http://localhost:10510/restful/usuarios/{id}", Usuario.class, userId);

        System.out.println(user.getUsername());

        return " <p> " + user.getUsername() + " - " + user.getId() + "</p>";
    }

    //PETICION TIPO POST

    @RequestMapping(value = "/api-consumer/post", method = RequestMethod.GET)
    public @ResponseBody String postAUsuario() {
        Usuario toInsertU = new Usuario("Eufrasio", "Cantinflas", "Alpargata", "Newuser", "jarl","Calle toballa", 123802394, false);
        Usuario resultU =
                restTemplate.postForObject("http://localhost:10510/restful/usuarios", toInsertU, Usuario.class);

        return "<p> Usuario insertado </p>";
    }


    //PETICION TIPO PUT
    @RequestMapping(value = "/api-consumer/put", method = RequestMethod.GET)
    public @ResponseBody
    String updateAUsuario() {

        Usuario updateUser = new Usuario("pepe","gomez","perez","Monty", "1234", "calle si", 458478596, false);

        restTemplate.put("http://localhost:10510/restful/usuarios/{id}", updateUser , "2");


        return "<h1> Usuario actualizado por microservicio: </h1> <p> " + updateUser.getId() + " - " + updateUser.getUsername() + "</p>";
    }


    //PETICION TIPO DELETE
    @RequestMapping(value = "/api-consumer/delete", method = RequestMethod.GET)
    public @ResponseBody
    String deleteAUsuario() {
        restTemplate.delete("http://localhost:10510/restful/usuarios/{id}", "2");


        return "<h1> Usuario eliminado correctamente por microservicio: </h1>";
    }



}
