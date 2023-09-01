package org.example.service;

import org.example.domain.Comment;

import java.util.List;

public interface CommentService {
    Comment insert(Comment comment);

    List<Comment> getAll();

    List<Comment> getByBookId(int bookId);

    void deleteById(int id);

    Comment update(int id, String content);
}
