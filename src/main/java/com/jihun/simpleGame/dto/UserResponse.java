package com.jihun.simpleGame.dto;

import com.jihun.simpleGame.entity.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;

    private String username;

//    private String password;

//    private String name;
//
//    private Gender gender;
//
//    private int birth;
//
//    private int phoneNumber;

    public static UserResponse fromEntity(Member user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
//                .password(user.getPassword())
//                .name(user.getName())
//                .gender(user.getGender())
//                .birth(user.getBirth())
//                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
