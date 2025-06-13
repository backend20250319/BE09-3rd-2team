package com.gp.nut.auth.service;

import com.gp.nut.auth.dto.LoginRequest;
import com.gp.nut.auth.dto.RefreshTokenRequest;
import com.gp.nut.auth.dto.TokenResponse;
import com.gp.nut.auth.repository.UserRepository;
import com.gp.nut.jwt.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RefreshTokenRequest refreshTokenRequest;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse login(LoginRequest request) {

//        User user = userRepository.findByUsername(request.getUsername())
//                .orElseThrow(() -> new BadCredentialsException("올바르지 않은 아이디 혹은 비밀번호"));
//
//        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//            throw new BadCredentialsException("올바르지 않은 아이디 혹은 비밀번호");
//        }

        String accessToken = jwtTokenProvider.createToken(user.getUsername(), user.getRole().name(), user.getId());
        String refreshToken = jwtTokenProvider.createRefreshToken(user.getUsername(), user.getRole().name(), user.getId());






    }
}
