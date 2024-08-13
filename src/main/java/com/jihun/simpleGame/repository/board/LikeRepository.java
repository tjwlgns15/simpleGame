package com.jihun.simpleGame.repository.board;

import com.jihun.simpleGame.entity.board.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
