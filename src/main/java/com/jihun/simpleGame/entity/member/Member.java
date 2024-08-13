package com.jihun.simpleGame.entity.member;

import com.jihun.simpleGame.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    private Gender gender;
//
//    @Column(nullable = false)
//    private int birth;
//
//    @Column(nullable = false)
//    private int phoneNumber;

}
