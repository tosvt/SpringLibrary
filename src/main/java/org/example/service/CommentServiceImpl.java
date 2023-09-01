package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Comment;
import org.example.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Comment insert(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getByBookId(int bookId) {
        return commentRepository.findByBookId(bookId);
    }

    @Override
    public void deleteById(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment update(int id, String content) {
        return commentRepository.save(
                Comment.builder()
                .id(id)
                .content(content).build());
    }
}
