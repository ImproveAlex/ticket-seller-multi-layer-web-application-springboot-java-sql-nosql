package com.tiw8205.admin8205.controllers;

import com.tiw8205.admin8205.mysql.entities.Evento;
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
public class thymeleafEventoController {

    @Autowired
    RestTemplate restTemplate;

    //PETICION REDIRECT
    @GetMapping(value = "/goto/event")
    public String redirectEvent() {
        return "eventView";
    }

    //PETICION RETURN
    @GetMapping(value = "/goto/event/index")
    public String redirectIndex() {
        return "index";
    }

    //PETICION TIPO GET
    @GetMapping(value = "/read/event")
    public String getEventByCallingApi(String titulo, Model model) {
        Evento event =
                restTemplate.getForObject("http://localhost:10530/restful/eventos/get/{titulo}", Evento.class, titulo);
        model.addAttribute("rEvento", event);

        return "eventView";
    }

    //PETICION TIPO GET ALL
    @GetMapping(value = "/read-all/event")
    public String getAllEventsByCallingApi(Model model) {
       Evento[] allevent =
                restTemplate.getForObject("http://localhost:10530/restful/eventos/get/all", Evento[].class);
        model.addAttribute("listEventos", allevent);
        return "eventView";
    }

    //PETICION TIPO POST

    @GetMapping(value = "/create/event")
    public String postAEvent(Evento toInsertE, Model model) {
        Evento resultE =
                restTemplate.postForObject("http://localhost:10530/restful/eventos/post", toInsertE, Evento.class);
        model.addAttribute("cEvento", resultE);

        return "eventView";
    }


    //PETICION TIPO PUT
    @GetMapping(value = "/update/event")
    public String updateAEvent(Evento toUpdateE, Model model) {
        HttpEntity<Evento> requestUpdate = new HttpEntity<>(toUpdateE);

        restTemplate.exchange("http://localhost:10530/restful/eventos/put", HttpMethod.PUT, requestUpdate, Void.class);

        String updatedString = "Evento " + toUpdateE.getTitulo() + " actualizado con éxito";
        model.addAttribute("updatedString", updatedString);

        return "eventView";
    }


    //PETICION TIPO DELETE
    @GetMapping(value = "/delete/event")
    public String deleteAEvent(String titulo, Model model) {
        restTemplate.delete("http://localhost:10530/restful/eventos/delete/{titulo}", titulo);
        String deletedString = "Evento " + titulo + " eliminado correctamente por microservicio.";
        model.addAttribute("deletedString", deletedString);

        return "eventView";
    }

}
