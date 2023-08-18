package com.dailyCodeBuffer.ProductService.demo.Product.Exception;

import com.dailyCodeBuffer.ProductService.demo.Product.Model.ErrorResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestResponseEntityException extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ProductServiceCustomException.class)
   public ResponseEntity<ErrorResp> handleProductServiceException(ProductServiceCustomException exception){

        return new ResponseEntity<>(new ErrorResp().builder().errorMessage(exception.getMessage()).errorCode(exception.getErrorCode()).build(), HttpStatus.NOT_FOUND);
    }


}
