package br.com.claudes.challenge.exceptions;

import br.com.claudes.challenge.dto.ErrorMessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {Exception.class})
  public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request){
    String description = e.getLocalizedMessage();
    if(description == null) description = e.toString();

    ErrorMessageDto errorMessageDto = new ErrorMessageDto(description, LocalDateTime.now());

    log.error("Exception in this method {}", e.getStackTrace());
    return new ResponseEntity<>(errorMessageDto,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
