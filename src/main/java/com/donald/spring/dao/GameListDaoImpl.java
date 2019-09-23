package com.donald.spring.dao;

import com.donald.spring.model.GameList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameListDaoImpl implements GameListDao {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public long save(GameList gameList) {
        sessionFactory.getCurrentSession().save(gameList);
        return gameList.getId();
    }

    @Override
    public GameList get(long id) {
        return  sessionFactory.getCurrentSession().get(GameList.class,id);
    }

    @Override
    public List<GameList> list() {
       List<GameList> list = sessionFactory.getCurrentSession().createQuery("FROM GameList").list();
       return list;
    }

    @Override
    public void update(long id, GameList gameList) {
        Session session = sessionFactory.getCurrentSession();
        GameList oldGameList = session.byId(GameList.class).load(id);
        oldGameList.setTitle(gameList.getTitle());
        oldGameList.setAuthor(gameList.getAuthor());
        session.flush();

    }

    @Override
    public void delete(long id) {

        Session session = sessionFactory.getCurrentSession();
        GameList gameList = session.byId(GameList.class).load(id);
        session.delete(gameList);

    }
}
