package com.unicef.handler;

import com.unicef.dto.donate.CMRespDto;
import com.unicef.exception.CustomValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestController // 예외를 낚아챔 (본인과 일치하는 예외) @ControllerAdvice + @ResponseBody
@RestControllerAdvice // 예외를 낚아채게 도와줌
public class RestControllerExceptionHandler {
    @ExceptionHandler(CustomValidationException.class) //CustomValidationException 예외가 발생하면 실행
    public ResponseEntity<?> validationErrorException(CustomValidationException e){

        log.info("[RestControllerExceptionHandler] e.getErrorMap(): {}", e.getErrorMap());

        return ResponseEntity
                .badRequest()
                .body(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()));
    }

}
