package org.example.repository;

import org.example.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Modifying
    @Query("update Comment c set c.content = :content where c.id = :id")
    void updateCommentById(@Param("id") int id,
                           @Param("content") String content);

    List<Comment> findByBookId(int id);
}
