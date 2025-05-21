package com.wsc.Wsc_Ponto_Backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "recovery_token")
public class RecoveryToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    private String recoveryToken;

    @Column(nullable = false)
    private LocalDateTime expiration;
}
