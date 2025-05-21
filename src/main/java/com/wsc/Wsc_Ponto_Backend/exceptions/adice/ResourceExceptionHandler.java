package com.wsc.Wsc_Ponto_Backend.exceptions.adice;

import com.wsc.Wsc_Ponto_Backend.exceptions.ValidationError;
import com.wsc.Wsc_Ponto_Backend.exceptions.runtime.PersistFailedException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@EnableWebMvc
@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersistFailedException.class)
    public ResponseEntity<Object> persistFailedException(PersistFailedException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidationError err = new ValidationError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setErrorCode(status.name());
        err.setError(e.getMessage());
        err.setPath(request.getRequestURI());
        err.addError("PersistFailedException", e.getMessage());
        return ResponseEntity.status(status).body(err);
    }
}
