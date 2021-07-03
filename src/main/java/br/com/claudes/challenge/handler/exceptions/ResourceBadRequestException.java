package br.com.claudes.challenge.handler.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Claudes dos Santos Ferreira Gomes on 2/7/21.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceBadRequestException extends RuntimeException{
  public ResourceBadRequestException(String message) {
    super(message);
  }
}
