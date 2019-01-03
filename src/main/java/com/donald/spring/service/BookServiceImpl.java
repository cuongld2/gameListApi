package com.donald.spring.service;

import com.donald.spring.dao.BookDao;
import com.donald.spring.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional
    public long save(Book book) {

        return bookDao.save(book);

    }

    @Override
    @Transactional
    public Book get(long id) {
        return bookDao.get(id);
    }

    @Override
    @Transactional
    public List<Book> list() {
        return bookDao.list();
    }

    @Override
    @Transactional
    public void update(long id, Book book) {

        bookDao.update(id,book);

    }

    @Override
    @Transactional
    public void delete(long id) {

        bookDao.delete(id);

    }
}
