package com.citi.creditcard.utility;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ErrorResponseHandler {
    public static  ResponseEntity<Object> generateResponse(Exception e, HttpStatus status , Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", LocalDateTime.now());
        map.put("status", status);
        map.put("message", e.getMessage());
        map.put("data", obj);
        return new ResponseEntity<>(map, status);
    }

}

