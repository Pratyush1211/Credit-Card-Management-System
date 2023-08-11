package com.citi.creditcard.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(LocalDateTime timestamp, String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", timestamp);
        map.put("message", message);
        map.put("status", status.getReasonPhrase());
        map.put("data", responseObj);
        return new ResponseEntity<>(map,status);
    }
}