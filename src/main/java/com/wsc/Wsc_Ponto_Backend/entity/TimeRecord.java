package com.wsc.Wsc_Ponto_Backend.entity;

import com.wsc.Wsc_Ponto_Backend.enuns.OriginEnum;
import com.wsc.Wsc_Ponto_Backend.enuns.TypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "time_record")
public class TimeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TypeEnum type;

    @Enumerated(EnumType.STRING)
    @Column(name = "origin", nullable = false)
    private OriginEnum origin;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
