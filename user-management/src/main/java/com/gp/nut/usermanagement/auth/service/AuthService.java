package com.gp.nut.usermanagement.auth.service;

import com.gp.nut.usermanagement.auth.dto.LoginRequest;
import com.gp.nut.usermanagement.auth.dto.TokenResponse;
import com.gp.nut.usermanagement.auth.entity.RefreshToken;
import com.gp.nut.usermanagement.auth.repository.RefreshTokenRepository;
import com.gp.nut.usermanagement.command.entity.User;
import com.gp.nut.usermanagement.command.repository.UserRepository;
import com.gp.nut.usermanagement.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final RefreshTokenRepository refreshTokenRepository;

    public TokenResponse login(LoginRequest request) {

        // 아이디 비밀번호 불일치 여부
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new BadCredentialsException("올바르지 않은 아이디 혹은 비밀번호"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("올바르지 않은 아이디 혹은 비밀번호");
        }

        String accessToken = jwtTokenProvider.createToken(user.getUsername(), user.getRole().name(), user.getId());
        String refreshToken = jwtTokenProvider.createRefreshToken(user.getUsername(), user.getRole().name(), user.getId());

        RefreshToken tokenEntity = RefreshToken.builder()
                .username(user.getUsername())
                .token(refreshToken)
                .expiryDate(
                        new Date(System.currentTimeMillis()
                                + jwtTokenProvider.getRefreshExpiration())
                )
                .build();

        refreshTokenRepository.save(tokenEntity);

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

}
