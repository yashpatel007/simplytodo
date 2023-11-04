package com.simplytodo.errors;

public class TodoException extends Exception{
    private TodoErrorStatus status;
    public TodoException(TodoErrorStatus status, String message) {
        super(message);
        this.status = status;
    }

    public TodoErrorStatus getStatus() {
        return status;
    }
}
