package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Author;
import org.example.domain.Book;
import org.example.domain.Comment;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
import org.example.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibDemoService {

    private final AuthorRepository authorRepository;

    private final CommentRepository commentRepository;

    private final BookRepository bookRepository;

    /*public LibDemoService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }*/

    public void authorDemo() {

        List<Author> authorList = authorRepository.findAll();

        System.out.println("========");
        for (Author author : authorList) {
            System.out.println(author);
        }
        System.out.println("========");

        Author author = Author.builder()
                .name("Сергей")
                .build();

        authorRepository.save(author);
        authorList = authorRepository.findAll();

        System.out.println("========");
        for (Author author1 : authorList) {
            System.out.println(author1);
        }
        System.out.println("========");

        System.out.println(authorRepository.findByName("Имя автора 1"));

    }

    @Transactional
    public void bookDemo() {
        List<Book> bookList = bookRepository.findAll();
//        bookList.stream().map(Book::getName).forEach(System.out::println);
        /*for (Book book : bookList) {
            System.out.println(book.getAuthor() + ":");
            System.out.println(book.getAuthor().getName() + "," + book.getGenre().getName());

            List<Comment> commentList = book.getCommentList();
            for (Comment comment : commentList) {
                System.out.println(comment.getContent());
            }
        }*/
        List<Book> bookList1 = bookRepository.findByName("Название книги 3");
        for (Book book1 : bookList1) {
            System.out.println(book1.getAuthor() + ":");
            System.out.println(book1.getAuthor().getName() + "," + book1.getGenre().getName());

            List<Comment> commentList = book1.getCommentList();
            for (Comment comment : commentList) {
                System.out.println(comment.getContent());
            }
        }
    }

    @Transactional
    public void commentDemo() {
        commentRepository.updateCommentById(1, "Очень интересно, ничего не понятно");
        List<Comment> commentList = commentRepository.findAll();

        for (Comment comment : commentList) {

            System.out.println(comment.getId() + " - " + comment.getContent());
        }

        commentList = commentRepository.findByBookId(2);

        for (Comment comment : commentList) {

            System.out.println(comment.getId() + " - " + comment.getContent());
        }
    }
}
