package com.donald.spring.service;

import com.donald.spring.model.GameList;

import java.util.List;

public interface GameListService {

    // Save the record
    long save(GameList gameList);

    // Get a single record
    GameList get(long id);


    // Get all the records

    List<GameList> list();


    // Update the record
    void update(long id, GameList gameList);

    // Delete a record
    void delete(long id);

}
