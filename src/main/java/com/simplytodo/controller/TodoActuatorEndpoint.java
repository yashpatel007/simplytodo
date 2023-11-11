package com.simplytodo.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

@Endpoint(id = "todo-actuator-endpoint")
public class TodoActuatorEndpoint {
    @ReadOperation
    public String customOperation() {
        // Implement your custom logic here
        return "Todo custom endpoint response";
    }
}
