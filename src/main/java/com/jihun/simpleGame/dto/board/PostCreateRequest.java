package com.jihun.simpleGame.dto.board;

import com.jihun.simpleGame.entity.board.Comment;
import com.jihun.simpleGame.entity.board.Like;
import com.jihun.simpleGame.entity.member.Member;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateRequest {

    private String title;
    private String content;
    private Member member;
}
