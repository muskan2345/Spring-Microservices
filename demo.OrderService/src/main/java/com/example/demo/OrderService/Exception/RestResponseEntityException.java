package com.example.demo.OrderService.Exception;


import com.example.demo.OrderService.Model.ErrorResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestResponseEntityException extends ResponseEntityExceptionHandler {


    @ExceptionHandler(OrderServiceCustomException.class)
   public ResponseEntity<ErrorResp> handleOrderServiceException(OrderServiceCustomException exception){

        return new ResponseEntity<>(new ErrorResp().builder().errorMessage(exception.getMessage()).errorCode(exception.getErrorCode()).build(), HttpStatus.NOT_FOUND);
    }


}
