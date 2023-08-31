package org.example.repository;

import org.example.domain.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Override
    @EntityGraph(attributePaths = {"author", "genre", "commentList"}) // джойним необходимое
    List<Book> findAll();

    List<Book> findByName(String name);
}
