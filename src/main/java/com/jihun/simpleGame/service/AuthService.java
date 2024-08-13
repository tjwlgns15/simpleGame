package com.jihun.simpleGame.service;

import com.jihun.simpleGame.dto.UserResponse;
import com.jihun.simpleGame.entity.member.Role;
import com.jihun.simpleGame.entity.member.Member;
import com.jihun.simpleGame.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member saveUser(Member user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == Role.ADMIN) {
            user.setRole(Role.ADMIN);
        } else {
            user.setRole(Role.USER);
        }
        return memberRepository.save(user);
    }

    public UserResponse findByUsername(String username) {
        Member user = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return UserResponse.fromEntity(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member user = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
