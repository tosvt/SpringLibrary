package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Author;
import org.example.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    @Override
    public Author insert(Author author) {
        //...проверка данных
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAll() {

        return authorRepository.findAll();
    }

    @Override
    public Author getById(int id) {

        return authorRepository.getById(id);
    }

    @Override
    public Author getByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public Author update(int id, String nameAuthor) {
        Author author = Author.builder()
                .id(id)
                .name(nameAuthor)
                .build();

        return authorRepository.save(author);
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }
}
