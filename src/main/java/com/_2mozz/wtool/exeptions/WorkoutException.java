package com._2mozz.wtool.exeptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WorkoutException extends RuntimeException {


    public WorkoutException(String message) {
        super(message);
    }
}
