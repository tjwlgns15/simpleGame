package com.jihun.simpleGame.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static jakarta.servlet.http.HttpServletResponse.*;
import static jakarta.servlet.http.HttpServletResponse.SC_NOT_FOUND;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    MEMBER_NOT_FOUND(SC_NOT_FOUND, "존재하지 않는 회원입니다."),
    ALREADY_EXISTS_USERNAME(SC_CONFLICT, "이미 존재하는 아이디입니다."),
    INVALID_TOKEN(SC_BAD_REQUEST, "유효하지 않은 토큰입니다."),
    ;

    private final int code;
    private final String massage;



}
