package com.simplytodo.errors;

import com.simplytodo.pojo.TodoErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TodoErrorController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<TodoErrorResponse> handleException(Exception e) {
        TodoErrorResponse errorResponse = new TodoErrorResponse();
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        errorResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
