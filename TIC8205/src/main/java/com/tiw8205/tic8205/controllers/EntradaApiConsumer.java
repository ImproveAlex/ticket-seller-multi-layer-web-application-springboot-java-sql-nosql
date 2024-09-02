package com.tiw8205.tic8205.controllers;

import com.tiw8205.tic8205.mysql.entities.Entrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class EntradaApiConsumer {

    @Autowired
    RestTemplate restTemplate;

    //PETICION TIPO GET
    @RequestMapping(value = "/api-consumer-entrada/get", method = RequestMethod.GET)
    public @ResponseBody
    String getTicketByCallingApi() {
        System.out.println("Llega al GET en API CONSUMER");
        int ticketId = 1; // -> Por ejemplo buscamos esta entrada
        Entrada ticket =
                restTemplate.getForObject("http://localhost:10520/restful/entradas/{id}", Entrada.class, ticketId);

        System.out.println(ticket.getId());

        return " <p> " + ticket.getId() + " - " + ticket.getPropietario() + "</p>";
    }

    //PETICION TIPO POST

    @RequestMapping(value = "/api-consumer-entrada/post", method = RequestMethod.GET)
    public @ResponseBody
    String postAEntrada() {

        Entrada toInsertT = new Entrada("Slipknot", "vip", 150, "AMorata086", true);

        Entrada resultT =
                restTemplate.postForObject("http://localhost:10520/restful/entradas", toInsertT, Entrada.class);

        return "<h1> Entrada insertada por microservicio: </h1> <p> " + resultT.getPropietario() + resultT.getId() + "</p>";
    }


    //PETICION TIPO PUT
    @RequestMapping(value = "/api-consumer-entrada/put", method = RequestMethod.GET)
    public @ResponseBody
    String updateAEntrada() {

        Entrada updateTicket = new Entrada("Slipknot", "tierra", 200, "AMorata086", true);

        restTemplate.put("http://localhost:10520/restful/entradas/{id}", updateTicket, "2");


        return "<h1> Entrada actualizada por microservicio: </h1> <p> " + updateTicket.getId() + " - " + updateTicket.getPropietario() + "</p>";
    }


    //PETICION TIPO DELETE
    @RequestMapping(value = "/api-consumer-entrada/delete", method = RequestMethod.GET)
    public @ResponseBody
    String deleteAEntrada() {
        restTemplate.delete("http://localhost:10520/restful/entradas/{id}", "2");


        return "<h1> Entrada eliminada correctamente por microservicio: </h1>";
    }



}
