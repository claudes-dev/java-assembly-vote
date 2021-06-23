package br.com.claudes.challenge.controller;

import br.com.claudes.challenge.dto.session.CreateSessionRequestDto;
import br.com.claudes.challenge.model.Session;
import br.com.claudes.challenge.service.ISessionService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController()
@RequestMapping("/v1")
public class SessionController {

  @Autowired
  private ISessionService iSessionService;

  @PostMapping(value = "/session", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "API used to create a new session")
  public ResponseEntity<Session> createSession(@RequestBody CreateSessionRequestDto createSessionRequestDto){

    Session newSession = iSessionService.createSession(createSessionRequestDto);

    return new ResponseEntity<>(newSession, HttpStatus.OK);
  }

  @GetMapping(value = "/session", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "API used to get all sessions")
  public ResponseEntity<List<Session>> createSession(){
    return new ResponseEntity<>(iSessionService.getAllSessions(), HttpStatus.OK);
  }
}
