package com.wsc.Wsc_Ponto_Backend.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class StandardError {

    private Instant timestamp;
    private Integer status;
    private String errorCode;
    private String error;
    private String path;
}
