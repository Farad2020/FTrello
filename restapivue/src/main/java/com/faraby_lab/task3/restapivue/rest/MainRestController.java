package com.faraby_lab.task3.restapivue.rest;

import com.faraby_lab.task3.restapivue.entities.CardTasks;
import com.faraby_lab.task3.restapivue.entities.Cards;
import com.faraby_lab.task3.restapivue.entities.Users;
import com.faraby_lab.task3.restapivue.models.UserDTO;
import com.faraby_lab.task3.restapivue.repo.CardRepo;
import com.faraby_lab.task3.restapivue.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//vue-logger
//axios
@RestController
//TODO Stopped at 23 minute
//@CrossOrigin(origins = "http://192.168.1.202:8080")
@CrossOrigin(origins = "http://localhost:8080")
//http://localhost:8080/#/
//http://192.168.1.202:8080

@RequestMapping(value = "/api")
public class MainRestController {

    @Autowired
    private CardService cardService;

    @GetMapping(value = "/allcards")
    public ResponseEntity<?> getAllCards(){
        List<Cards> cards = cardService.getAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @PostMapping(value = "/addcard")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<?> addCard(@RequestBody Cards card){
        cardService.addCard(card);
        return ResponseEntity.ok(card);
    }

    @GetMapping(value = "/card/{id}")
    public ResponseEntity<?> getCard(@PathVariable(name = "id") Long id){
        Cards card= cardService.getCardById(id);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @GetMapping(value = "/cards/{id}")
    public ResponseEntity<?> getCardById(@PathVariable(name = "id") Long id){
        Cards card= cardService.getCardById(id);
        List<CardTasks> tasks = cardService.getCardTasks(id);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping(value = "/addcardtask")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<?> addCardTask(@RequestBody CardTasks task){
        cardService.addCardTask(task);
        return ResponseEntity.ok(task);
    }


    @PostMapping(value = "/savecard")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<?> saveCard(@RequestBody Cards card){
        cardService.saveCard(card);
        return ResponseEntity.ok(card);
    }

    @PostMapping(value = "/savecardtask")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<?> saveCardTask(@RequestBody CardTasks task){
        cardService.saveCardTask(task);
        return ResponseEntity.ok(task);
    }

    @PostMapping(value = "/deletecard")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<?> deleteCard(@RequestBody Cards card){
        cardService.deleteCard(card);
        return ResponseEntity.ok(card);
    }

    @GetMapping(value = "/get_cards_by_name/{name}")
    public ResponseEntity<?> getCardsByName(@PathVariable(name = "name") String name){
        List<Cards> cards = cardService.getCardsByName(name);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping(value = "/profile")
    public ResponseEntity<?> profilePage(){
        Users user = getUser();
        return new ResponseEntity<>(new UserDTO(user.getId(), user.getEmail(), user.getRoles()), HttpStatus.OK);
    }

    private Users getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            Users user = (Users) authentication.getPrincipal();
            return user;
        }
        return null;
    }
}
