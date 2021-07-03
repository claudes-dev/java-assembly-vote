package br.com.claudes.challenge.handler;

import br.com.claudes.challenge.domain.dto.error.GenericErrorMessageDto;
import br.com.claudes.challenge.handler.exceptions.ResourceBadRequestException;
import br.com.claudes.challenge.handler.exceptions.ResourceNotFoundException;
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

    GenericErrorMessageDto genericErrorMessageDto = getGenericErrorMessageDto(HttpStatus.INTERNAL_SERVER_ERROR, description, e.getClass().getName());

    log.error("Cause: {}", e.getMessage());
    log.error("Exception in this method {}", e.getStackTrace());
    return new ResponseEntity<>(genericErrorMessageDto,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = {ResourceBadRequestException.class})
  public ResponseEntity<?> handleBadRequestException(ResourceBadRequestException resourceBadRequestException){
    GenericErrorMessageDto genericErrorMessageDto = getGenericErrorMessageDto(HttpStatus.BAD_REQUEST, resourceBadRequestException.getMessage(), resourceBadRequestException.getClass().getName());

    log.error("Cause: {}", resourceBadRequestException.getMessage());
    log.error("Bad Request in this method {}", resourceBadRequestException.getStackTrace());
    return new ResponseEntity<>(genericErrorMessageDto,new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {ResourceNotFoundException.class})
  public ResponseEntity<?> handleResourNotFoundException(ResourceNotFoundException resourceNotFoundException){
    GenericErrorMessageDto genericErrorMessageDto = getGenericErrorMessageDto(HttpStatus.NOT_FOUND, resourceNotFoundException.getMessage(), resourceNotFoundException.getClass().getName());

    log.error("Cause: {}", resourceNotFoundException.getMessage());
    log.error("Not found in this method {}", resourceNotFoundException.getStackTrace());
    return new ResponseEntity<>(genericErrorMessageDto,new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  private GenericErrorMessageDto getGenericErrorMessageDto(HttpStatus httpStatus, String messageError, String className) {
    return GenericErrorMessageDto.builder()
            .title(httpStatus.getReasonPhrase())
            .detail(messageError)
            .currentDate(LocalDateTime.now())
            .statusCode(httpStatus.value())
            .developerMessage(className)
            .build();
  }
}
