package com.tiw8205.cha8205.controllers;

import java.util.List;
import com.tiw8205.cha8205.mysql.entities.Mensaje;
import com.tiw8205.cha8205.repos.MensajeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChatRestController {

    @Autowired
    MensajeDAO mDao;

    static final String basePath = "/restful";

    @RequestMapping(value = basePath + "/mensajes", method = RequestMethod.GET/*, produces ="application/json"*/)
    public @ResponseBody ResponseEntity<List<Mensaje>> getAllChats() {

        try {
            List<Mensaje> chatList = mDao.findAll();

            if(chatList == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(chatList, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = basePath + "/mensajesusuario/{emisor}", method = RequestMethod.GET/*, produces = "application/json"*/)
    public @ResponseBody ResponseEntity<List<Mensaje>> getUserMessages(@PathVariable(value = "emisor", required = true) String emisor){

        try {

            List<Mensaje> messageList = mDao.findByEmisor(emisor);

            return new ResponseEntity<>(messageList, HttpStatus.OK);

        } catch (Exception ex) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = basePath + "/mensaje", method = RequestMethod.POST/*, produces = "application/json"*/)
    public @ResponseBody ResponseEntity<Mensaje> sendMessage(@RequestBody Mensaje mensaje) {

        try {

            mDao.save(mensaje);
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = basePath + "/chats/{emisor}/{receptor}", method = RequestMethod.GET/*, produces = "application/json"*/)
    public ResponseEntity<List<Mensaje>> getChat(@PathVariable(value = "emisor", required = true) String emisor,
                                               @PathVariable(value = "receptor", required = true) String receptor) {

        try {

            List<Mensaje> messageList = mDao.findByEmisorAndReceptor(emisor, receptor);

            if (messageList.isEmpty()) {

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            } else {

                return new ResponseEntity<>(messageList, HttpStatus.OK);
            }

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "/mensajeslike/{expression}", method = RequestMethod.GET/*, produces = "application/json"*/)
    public ResponseEntity<List<Mensaje>> getMessagesLike(@PathVariable(value = "expression", required = true) String expression) {

        try {
            List<Mensaje> messageList = mDao.findByMensajeLikeOrderByMensajeAsc(expression);

            return new ResponseEntity<>(messageList, HttpStatus.OK);

        } catch (Exception ex) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
