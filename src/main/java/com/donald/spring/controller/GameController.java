package com.donald.spring.controller;


import com.donald.spring.model.GameList;
import com.donald.spring.service.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
public class GameController {

    @Autowired
    private GameListService gameListService;

    // Get all the games

    @GetMapping("/api/game")
    public ResponseEntity<List<GameList>> list(){


       List<GameList> list = gameListService.list();
       return ResponseEntity.ok().body(list);
    }

    // Save the game
    @PostMapping("/api/game")
    public ResponseEntity<?> save (@RequestBody GameList gameList){

        long id = gameListService.save(gameList);
        return ResponseEntity.ok().body("Game created with id :"+id);

    }

    // Get a single record
    @GetMapping("api/game/{id}")
    public ResponseEntity<GameList> get(@PathVariable("id") long id){

        GameList gameList = gameListService.get(id);
        return ResponseEntity.ok().body(gameList);

    }
    // Update book record
    @PutMapping("/api/game/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id,@RequestBody GameList gameList){

        gameListService.update(id, gameList);
        return ResponseEntity.ok().body("Game has been updated");

    }

    //Delete gane record
    @DeleteMapping("/api/game/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){

        gameListService.delete(id);
        return ResponseEntity.ok().body("Delete the game record");

    }



}
