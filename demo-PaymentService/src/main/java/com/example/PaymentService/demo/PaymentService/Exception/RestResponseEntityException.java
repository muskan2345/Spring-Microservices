package com.example.PaymentService.demo.PaymentService.Exception;



import com.example.PaymentService.demo.PaymentService.Model.ErrorResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestResponseEntityException extends ResponseEntityExceptionHandler {


    @ExceptionHandler(PaymentServiceCustomException.class)
   public ResponseEntity<ErrorResp> handlePaymentServiceException(PaymentServiceCustomException exception){

        return new ResponseEntity<>(new ErrorResp().builder().errorMessage(exception.getMessage()).errorCode(exception.getErrorCode()).build(), HttpStatus.NOT_FOUND);
    }


}
