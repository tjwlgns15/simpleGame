package com.jihun.simpleGame.dto.board;

import com.jihun.simpleGame.entity.board.Comment;
import com.jihun.simpleGame.entity.board.Like;
import com.jihun.simpleGame.entity.board.Post;
import com.jihun.simpleGame.entity.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private List<Comment> comments;
    private List<Like> likes;
    private Member member;
    private LocalDate createdAt;

    public static PostResponse fromEntity(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .comments(post.getComments())
                .likes(post.getLikes())
                .member(post.getMember())
                .createdAt(LocalDate.from(post.getCreatedAt()))
                .build();
    }

}
