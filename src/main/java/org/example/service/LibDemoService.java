package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Author;
import org.example.domain.Book;
import org.example.domain.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibDemoService {

    private final AuthorService authorService;

    private final BookService bookService;

    private final GenreService genreService;

    /*public LibDemoService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }*/

    public void authorDemo() {

        List<Author> authorList = authorService.getAll();

        System.out.println("========");
        for (Author author : authorList) {
            System.out.println(author);
        }
        System.out.println("========");


        authorService.update(1, "Иван");
        authorList = authorService.getAll();

        System.out.println("========");
        for (Author author1 : authorList) {
            System.out.println(author1);
        }
        System.out.println("========");


    }

    @Transactional
    public void bookDemo() {
        List<Book> bookList = bookService.getAll();
//        bookList.stream().map(Book::getName).forEach(System.out::println);
        for (Book book : bookList) {
            System.out.println(book.getAuthor() + ":");
            System.out.println(book.getAuthor().getName() + "," + book.getGenre().getName());

            List<Comment> commentList = book.getCommentList();
            for (Comment comment : commentList) {
                System.out.println(comment.getContent());
            }
        }

        bookService.insert("Название книги 4", "Имя автора 4", "Жанр 3");

        bookList = bookService.getAll();
//        bookList.stream().map(Book::getName).forEach(System.out::println);
        for (Book book : bookList) {
            System.out.println(book.getAuthor() + ":");
            System.out.println(book.getAuthor().getName() + "," + book.getGenre().getName());

            List<Comment> commentList = book.getCommentList();
            if (commentList != null) {
                for (Comment comment : commentList) {
                    System.out.println(comment.getContent());
                }
            }
        }
    }

    @Transactional
    public void commentDemo() {
        /*commentRepository.updateCommentById(1, "Очень интересно, ничего не понятно");
        List<Comment> commentList = commentRepository.findAll();

        for (Comment comment : commentList) {

            System.out.println(comment.getId() + " - " + comment.getContent());
        }

        commentList = commentRepository.findByBookId(2);

        for (Comment comment : commentList) {

            System.out.println(comment.getId() + " - " + comment.getContent());
        }*/
    }
}
