package com.jihun.simpleGame.service.board;

import com.jihun.simpleGame.dto.board.PostCreateRequest;
import com.jihun.simpleGame.dto.board.PostResponse;
import com.jihun.simpleGame.entity.board.Post;
import com.jihun.simpleGame.repository.board.CommentRepository;
import com.jihun.simpleGame.repository.board.LikeRepository;
import com.jihun.simpleGame.repository.board.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;

    public List<PostResponse> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostResponse> postResponses = new ArrayList<>();

        for (Post post : posts) {
            postResponses.add(PostResponse.fromEntity(post));
        }
        return postResponses;
    }

    @Transactional
    public Long createPost(PostCreateRequest request) {
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .member(request.getMember())
                .build();

        Post savePost = postRepository.save(post);
        return savePost.getId();
    }
}
