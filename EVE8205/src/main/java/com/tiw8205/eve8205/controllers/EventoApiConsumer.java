package com.tiw8205.eve8205.controllers;

import com.tiw8205.eve8205.mysql.entities.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import java.sql.Date;

@Controller
public class EventoApiConsumer {

    @Autowired
    RestTemplate restTemplate;

    //PETICION TIPO GET
    @RequestMapping(value = "/api-consumer/get", method = RequestMethod.GET)
    public @ResponseBody
    String getUserByCallingApi() {
        System.out.println("Llega al GET en API CONSUMER");
        int eventoId = 1; // -> Por ejemplo buscamos este usuario
        Evento evento =
                restTemplate.getForObject("http://localhost:10530/restful/eventos/{id}", Evento.class, eventoId);

        System.out.println(evento.getCiudad());

        return " <p> " + evento.getCiudad() + " - " + evento.getCategoria() + "</p> <br> <img src = \""  + evento.getImagen() + "\">";
    }

    //PETICION TIPO POST

    @RequestMapping(value = "/api-consumer/post", method = RequestMethod.GET)
    public @ResponseBody
    String postAEvento() {
        Date date = Date.valueOf("2022-12-01");
        Evento toInsertU = new Evento();
        toInsertU.setTitulo("Amaneceres en vigo");
        toInsertU.setCategoria("Playa");
        toInsertU.setFecha(date);
        toInsertU.setCiudad("Vigo");
        toInsertU.setSala(2);
        toInsertU.setImagen("https://akamai.sscdn.co/uploadfile/letras/fotos/5/2/6/6/5266e6a16b5fe4501de0d70cb2935f48.jpg");

        Evento resultU =
                restTemplate.postForObject("http://localhost:10530/restful/eventos", toInsertU, Evento.class);

        return "<h1> Usuario insertado por microservicio: </h1> <p> " + resultU.getCiudad() + resultU.getCiudad() + "</p>";
    }


    //PETICION TIPO PUT
    @RequestMapping(value = "/api-consumer/put", method = RequestMethod.GET)
    public @ResponseBody
    String updateAEvento() {
        Date date = Date.valueOf("2023-02-23");
        Evento updateEvento = new Evento("Bad bunny 2024","Reggueton", date ,"Madrid", 2, "https://akamai.sscdn.co/uploadfile/letras/fotos/5/2/6/6/5266e6a16b5fe4501de0d70cb2935f48.jpg");
       /*newUsuario.setUsuario("UpdatedUser");
        newUsuario.setNombre("Eufrasio");
        newUsuario.setAp1("Cantinflas");
        newUsuario.setAp2("Alpargata");
        newUsuario.setPass("afhjkafh");
        newUsuario.setTlf(123802394);
        newUsuario.setDir("Calle almondiga");
        newUsuario.setAdministrador(false);*/

        restTemplate.put("http://localhost:10530/restful/eventos/{id}", updateEvento , "2");


        return "<h1> Usuario actualizado por microservicio: </h1> <p> " + updateEvento.getTitulo()+ " - " + updateEvento.getCategoria() + "</p>";
    }


    //PETICION TIPO DELETE
    @RequestMapping(value = "/api-consumer/delete", method = RequestMethod.GET)
    public @ResponseBody
    String deleteAEvento() {
        restTemplate.delete("http://localhost:10530/restful/eventos/{id}", "2");


        return "<h1> Usuario eliminado correctamente por microservicio: </h1>";
    }



}

