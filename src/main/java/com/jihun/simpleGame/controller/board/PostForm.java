package com.jihun.simpleGame.controller.board;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostForm {

    @NotEmpty(message = "제목을 입력해주세요.")
    private String title;

    private String content;

}
