package com.donald.spring.service;

import com.donald.spring.dao.GameListDao;
import com.donald.spring.model.GameList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class GameListServiceImpl implements GameListService {

    @Autowired
    private GameListDao gameListDao;

    @Override
    @Transactional
    public long save(GameList gameList) {

        return gameListDao.save(gameList);

    }

    @Override
    @Transactional
    public GameList get(long id) {
        return gameListDao.get(id);
    }

    @Override
    @Transactional
    public List<GameList> list() {
        return gameListDao.list();
    }

    @Override
    @Transactional
    public void update(long id, GameList gameList) {

        gameListDao.update(id, gameList);

    }

    @Override
    @Transactional
    public void delete(long id) {

        gameListDao.delete(id);

    }
}
