package com.labcorp.codingtest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(WorkedDaysException.class)
    public ResponseEntity<Object> handleWorkedDaysException(WorkedDaysException ex, WebRequest request) {
        Map<String, Object> errMsg = new LinkedHashMap<>();
        errMsg.put("code", ex.getErrorCode());
        errMsg.put("timestamp", LocalDateTime.now());
        errMsg.put("message", ex.getMessage());
        return new ResponseEntity<>(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(VacationDaysException.class)
    public ResponseEntity<Object> handleVacationDaysException(VacationDaysException ex, WebRequest request) {
        Map<String, Object> errMsg = new LinkedHashMap<>();
        errMsg.put("code", ex.getErrorCode());
        errMsg.put("timestamp", LocalDateTime.now());
        errMsg.put("message", ex.getMessage());
        return new ResponseEntity<>(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> employeeNotFoundException(EmployeeNotFoundException ex, WebRequest request) {
        Map<String, Object> errMsg = new LinkedHashMap<>();
        errMsg.put("code", ex.getErrorCode());
        errMsg.put("timestamp", LocalDateTime.now());
        errMsg.put("message", ex.getMessage());
        return new ResponseEntity<>(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
