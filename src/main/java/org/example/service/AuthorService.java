package org.example.service;

import org.example.domain.Author;

import java.util.List;

public interface AuthorService {

    Author insert(Author author);

    List<Author> getAll();

    Author getById(int id);

    Author getByName(String name);

    Author update(int id, String nameAuthor);

    void deleteById(int id);
}
