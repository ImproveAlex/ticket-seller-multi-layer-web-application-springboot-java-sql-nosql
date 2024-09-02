package com.tiw8205.admin8205.controllers;

import com.tiw8205.admin8205.mysql.entities.Entrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Controller
public class thymeleafEntradaController {

    @Autowired
    RestTemplate restTemplate;

    //PETICION REDIRECT
    @GetMapping(value = "/goto/ticket")
    public String redirectTicket() {
        return "ticketView";
    }

    //PETICION RETURN
    @GetMapping(value = "/goto/ticket/index")
    public String redirectIndex() {
        return "index";
    }

    //PETICION TIPO GET
    @GetMapping(value = "/read-all-owner/ticket")
    public String getTicketsOwnersByCallingApi(String propietario, Model model) {
        System.out.println("Llega al GET en API CONSUMER");
        Entrada[] ticket =
                restTemplate.getForObject("http://localhost:10520/restful/entradas/get/owner/{propietario}", Entrada[].class, propietario);
        model.addAttribute("listEntradasPropietario", ticket);

        return "ticketView";
    }

    //PETICION TIPO GET
    @GetMapping(value = "/read-all-event/ticket")
    public String getTicketsEventsByCallingApi(String evento, Model model) {
        System.out.println("Llega al GET en API CONSUMER");
        Entrada[] tickets =
                restTemplate.getForObject("http://localhost:10520/restful/entradas/get/event/{evento}", Entrada[].class, evento);
        model.addAttribute("listEntradasEvento", tickets);

        return "ticketView";
    }

    //PETICION TIPO GET ALL
    @GetMapping(value = "/read-all/ticket")
    public String getAllTicketsByCallingApi(Model model) {
       Entrada[] allTicket =
                restTemplate.getForObject("http://localhost:10520/restful/entradas/get/all", Entrada[].class);
        model.addAttribute("listEntradas", allTicket);
        return "ticketView";
    }

    //PETICION TIPO POST

    @GetMapping(value = "/create/ticket")
    public String postATicket(Entrada toInsertT, Model model) {
        Entrada resultT =
                restTemplate.postForObject("http://localhost:10520/restful/entradas/post", toInsertT, Entrada.class);
        model.addAttribute("cEntrada", resultT);

        return "ticketView";
    }


    //PETICION TIPO PUT
    @GetMapping(value = "/update/ticket")
    public String updateATicket(Entrada toUpdateT, Model model) {
        System.out.println("LA ID DEL EVENTO A UPDATEAR ES: "+toUpdateT.getId());
        HttpEntity<Entrada> requestUpdate = new HttpEntity<>(toUpdateT);

        restTemplate.exchange("http://localhost:10520/restful/entradas/put", HttpMethod.PUT, requestUpdate, Void.class);
        String updatedString = "Entrada " + toUpdateT.getId() + " de " + toUpdateT.getPropietario() + " para el evento " + toUpdateT.getEvento() + " actualizada con éxito";
        model.addAttribute("updatedString", updatedString);

        return "ticketView";
    }


    //PETICION TIPO DELETE
    @GetMapping(value = "/delete/ticket")
    public String deleteATicket(String id, Model model) {
        restTemplate.delete("http://localhost:10520/restful/entradas/delete/{id}", id);
        String deletedString = "Entrada con ID:" + id + " eliminada correctamente por microservicio.";
        model.addAttribute("deletedString", deletedString);

        return "ticketView";
    }

}

