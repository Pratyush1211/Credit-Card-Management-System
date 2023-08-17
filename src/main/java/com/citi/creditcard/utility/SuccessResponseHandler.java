package com.citi.creditcard.utility;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class SuccessResponseHandler {
    public static ResponseEntity<Object> generateResponse(LocalDateTime timestamp, String message, HttpStatus status, Object responseObj, Page page) {
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", timestamp);
        map.put("status", status.value());
        map.put("message", message);
        map.put("data", responseObj);
        if(page == null) {
            return new ResponseEntity<>(map, status);
        }
        map.put("currentPage", page.getNumber());
        map.put("totalItems", page.getTotalElements());
        map.put("totalPages", page.getTotalPages());
        return new ResponseEntity<>(map,status);
    }
}

//const {data} = reponse.data