package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Author;
import org.example.domain.Book;
import org.example.domain.Genre;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
import org.example.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    @Override
    public Book insert(String nameBook, String nameAuthor, String nameGenre) {

        Author author = authorRepository.findByName(nameAuthor);
        if (author == null) {
            author = Author.builder()
                    .name(nameAuthor).build();
            author = authorRepository.save(author);
        }

        Genre genre = genreRepository.findByName(nameGenre);
        if (genre == null) {
            genre = Genre.builder()
                    .name(nameGenre)
                    .build();
            genre = genreRepository.save(genre);
        }

        Book book = Book.builder()
                .name(nameBook)
                .author(author)
                .genre(genre)
                .build();
        return bookRepository.save(book);
    }

    @Override
    public Book update(int id, String nameBook, String nameAuthor, String nameGenre) {
        Author author = authorRepository.findByName(nameAuthor);
        if (author == null) {
            author = Author.builder()
                    .name(nameAuthor).build();
            author = authorRepository.save(author);
        }

        Genre genre = genreRepository.findByName(nameGenre);
        if (genre == null) {
            genre = Genre.builder()
                    .name(nameGenre)
                    .build();
            genre = genreRepository.save(genre);
        }

        Book book = Book.builder()
                .id(id)
                .name(nameBook)
                .author(author)
                .genre(genre)
                .build();
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(int id) {
        return bookRepository.getById(id);
    }

    @Override
    public List<Book> getByName(String nameBook) {
        return bookRepository.findByName(nameBook);
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}
