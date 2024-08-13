package com.jihun.simpleGame.controller.board;


import com.jihun.simpleGame.dto.board.PostCreateRequest;
import com.jihun.simpleGame.dto.board.PostResponse;
import com.jihun.simpleGame.service.board.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public String getAllPosts(Model model) {
        List<PostResponse> boards = boardService.getAllPosts();
        model.addAttribute("boards", boards);
        return "board/boardList";
    }

    @GetMapping("/new")
    public String createBoardForm(Model model) {
        model.addAttribute("postForm", new PostForm());
        return "board/createPostForm";

    }

    @PostMapping
    public String createPost(@Valid PostForm postForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "board/createPostForm";
        }
        PostCreateRequest postCreateRequest = PostCreateRequest.builder()
                .title(postForm.getTitle())
                .content(postForm.getContent())
                .build();
        boardService.createPost(postCreateRequest);
        return "redirect:/boards/";

    }
}
