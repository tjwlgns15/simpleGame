package com.jihun.simpleGame.repository.board;

import com.jihun.simpleGame.entity.board.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
