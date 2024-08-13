package com.jihun.simpleGame.dto;

import com.jihun.simpleGame.entity.member.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String username;

    private String password;

    private Role role;

//    private String name;

//    private Gender gender;

//    private int birth;

//    private int phoneNumber;

}
