package com.example.university.exception;

import com.example.university.domain.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse> internalServerError() {
        return new ResponseEntity<>(
                new CommonResponse(-1, new Date(), "internal server error"),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
