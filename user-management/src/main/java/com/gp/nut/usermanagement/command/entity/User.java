package com.gp.nut.usermanagement.command.entity;

import com.gp.nut.usermanagement.command.dto.UserCreateRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_user")
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private UserRole role;

    public void setEncodedPassword(String encode) {
        this.password = encode;
    }

    public void updateUser(String username, String encodedPassword, String name, UserRole role) {
        this.username = username;
        this.password = encodedPassword;
        this.name = name;
    }
}
