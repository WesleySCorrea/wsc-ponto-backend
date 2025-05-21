package com.wsc.Wsc_Ponto_Backend.exceptions;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();
    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }
}
