package com.tiw8205.cha8205.controllers;

import com.tiw8205.cha8205.mysql.entities.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.util.List;

@Controller
public class ChatApiConsumer {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/restful/api-consumer/getAllMessages", method = RequestMethod.GET)
    public @ResponseBody String getAllMessagesAPI(){
        System.out.println("Entering getAllMessagesAPI in API CONSUMER");
        Mensaje[] msgList = restTemplate.getForObject("http://localhost:10540/mensajes", Mensaje[].class);

        System.out.println(msgList.length + " messages fetched.");

        String returnString = "<p> ";
        for (int i = 0; i < msgList.length; i++) {
            returnString += msgList[i].getEmisor() + "->" + msgList[i].getReceptor() + ": " + msgList[i].getMensaje() + "<br>";
        }
        returnString += " </p>";
        return returnString;
    }

    @RequestMapping(value = "/restful/api-consumer/getUserMessages", method = RequestMethod.GET)
    public @ResponseBody String getUserMessagesAPI(){
        String user = "AMorata086"; // Obtenemos los mensajes de este usuario

        System.out.println("Entering getUserMessagesAPI in API CONSUMER");
        Mensaje[] msgList = restTemplate.getForObject("http://localhost:10540/mensajesusuario/{emisor}", Mensaje[].class, user);

        System.out.println(msgList.length + " messages fetched for user " + user);

        String returnString = "<p> ";
        for (int i = 0; i < msgList.length; i++) {
            returnString += msgList[i].getId() + "::" + msgList[i].getEmisor() + "->" + msgList[i].getReceptor() + ": " + msgList[i].getMensaje() + "<br>";
        }
        returnString += " </p>";
        return returnString;
    }

    @RequestMapping(value = "/restful/api-consumer/sendMessage", method = RequestMethod.GET)
    public @ResponseBody String sendMessageAPI(){
        Mensaje newMsg = new Mensaje("AMorata086", "AMorata086", "Hola!!! Esto es un mensaje de prueba del metodo sendMessageAPI()");

        System.out.println("Entering sendMessageAPI in API CONSUMER");
        Mensaje insertedMsg = restTemplate.postForObject("http://localhost:10540/mensaje", newMsg, Mensaje.class);

        System.out.println("Message successfully inserted");

        return "<p> "/* + insertedMsg.getId() + "::" */+ insertedMsg.getEmisor() + "->" + insertedMsg.getReceptor() + ": " + insertedMsg.getMensaje() + " </p>";
    }

    @RequestMapping(value = "/restful/api-consumer/getChat", method = RequestMethod.GET)
    public @ResponseBody String getChatAPI(){
        String emisor = "AMorata086"; // Obtenemos los mensajes de este usuario al siguiente usuario
        String receptor = "AMorata086";

        System.out.println("Entering getChatAPI in API CONSUMER");
        Mensaje[] msgList = restTemplate.getForObject("http://localhost:10540/chats/{emisor}/{receptor}", Mensaje[].class, emisor, receptor);

        System.out.println(msgList.length + " messages fetched for chat: " + emisor + "->" + receptor);

        String returnString = "<p> ";
        for (int i = 0; i < msgList.length; i++) {
            returnString += msgList[i].getId() + "::" + msgList[i].getEmisor() + "->" + msgList[i].getReceptor() + ": " + msgList[i].getMensaje() + "<br>";
        }
        returnString += " </p>";
        return returnString;
    }

    @RequestMapping(value = "/restful/api-consumer/getMessagesLike", method = RequestMethod.GET)
    public @ResponseBody String getMessagesLikeAPI(){
        String expression = "Hola!!! Esto es un mensaje de prueba del metodo sendMessageAPI()";

        System.out.println("Entering getMessagesLikeAPI in API CONSUMER");
        Mensaje[] msgList = restTemplate.getForObject("http://localhost:10540/mensajeslike/{expression}", Mensaje[].class, expression);

        System.out.println(msgList.length + " messages fetched for expression like {" + expression + "}");

        String returnString = "<p> ";
        for (int i = 0; i < msgList.length; i++) {
            returnString += msgList[i].getId() + "::" + msgList[i].getEmisor() + "->" + msgList[i].getReceptor() + ": " + msgList[i].getMensaje() + "<br>";
        }
        returnString += " </p>";
        return returnString;
    }
}
