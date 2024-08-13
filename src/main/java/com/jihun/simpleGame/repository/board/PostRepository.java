package com.jihun.simpleGame.repository.board;

import com.jihun.simpleGame.entity.board.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
