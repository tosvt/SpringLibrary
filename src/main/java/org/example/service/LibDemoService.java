package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Author;
import org.example.domain.Book;
import org.example.domain.Comment;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibDemoService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    /*public LibDemoService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }*/

    public void authorDemo(){

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


    }

    @Transactional
    public void bookDemo(){
        List<Book> bookList = bookRepository.findAll();
//        bookList.stream().map(Book::getName).forEach(System.out::println);
        for (Book book : bookList) {
            System.out.println(book.getAuthor() + ":");
            System.out.println(book.getAuthor().getName() + "," + book.getGenre().getName());

            List<Comment> commentList = book.getCommentList();
            for (Comment comment : commentList) {
                System.out.println(comment.getContent());
            }
        }
    }
}
