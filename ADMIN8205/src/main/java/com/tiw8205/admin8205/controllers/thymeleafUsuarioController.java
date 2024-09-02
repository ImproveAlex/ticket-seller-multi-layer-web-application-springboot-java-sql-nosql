package com.tiw8205.admin8205.controllers;

import com.tiw8205.admin8205.mysql.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class thymeleafUsuarioController {

    @Autowired
    RestTemplate restTemplate;

    //PETICION REDIRECT
    @GetMapping(value = "/goto/user")
    public String redirectUser() {
        return "userView";
    }

    //PETICION RETURN
    @GetMapping(value = "/goto/user/index")
    public String redirectIndex() {
        return "index";
    }

    //PETICION TIPO GET
    @GetMapping(value = "/read/user")
    public String getUserByCallingApi(String username, Model model) {
        System.out.println("Llega al GET en API CONSUMER");
        System.out.println(username);
        Usuario user =
                restTemplate.getForObject("http://localhost:10510/restful/usuarios/get/{username}", Usuario.class, username);
        model.addAttribute("rUsuario", user);
        System.out.println(user.getUsername());

        return "userView";
    }

    //PETICION TIPO GET ALL
    @GetMapping(value = "/read-all/user")
    public String getAllUsersByCallingApi(Model model) {
       Usuario[] allUsers =
                restTemplate.getForObject("http://localhost:10510/restful/usuarios/get/all", Usuario[].class);
        model.addAttribute("listUsuarios", allUsers);
        return "userView";
    }

    //PETICION TIPO POST
    @GetMapping(value = "/create/user")
    public String postAUsuario(Usuario toInsertU, Model model) {
        Usuario resultU =
                restTemplate.postForObject("http://localhost:10510/restful/usuarios/post", toInsertU, Usuario.class);
        model.addAttribute("cUsuario", resultU);

        return "userView";
    }

    //PETICION TIPO PUT
    @GetMapping(value = "/update/user")
    public String updateAUsuario(Usuario toUpdateU, Model model) {
        HttpEntity<Usuario> requestUpdate = new HttpEntity<>(toUpdateU);

        restTemplate.exchange("http://localhost:10510/restful/usuarios/put", HttpMethod.PUT, requestUpdate, Void.class);

        String updatedString = "Usuario " + toUpdateU.getUsername() + " actualizado con éxito";
        model.addAttribute("updatedString", updatedString);

        return "userView";
    }


    //PETICION TIPO DELETE
    @GetMapping(value = "/delete/user")
    public String deleteAUsuario(String username, Model model) {
        restTemplate.delete("http://localhost:10510/restful/usuarios/delete/{username}", username);
        String deletedString = "Usuario " + username + " eliminado correctamente por microservicio.";
        model.addAttribute("deletedString", deletedString);

        return "userView";
    }

}
