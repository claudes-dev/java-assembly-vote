package br.com.claudes.challenge.controller;

import br.com.claudes.challenge.model.Vote;
import br.com.claudes.challenge.service.ITopicService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController()
@RequestMapping("/v1")
public class VoteController {

  @Autowired
  private ITopicService iTopicService;

  @PostMapping(value = "/vote", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "API used to insert a vote in the session")
  public ResponseEntity<Vote> insertAVote(){

//    log.info("Starting topic creation endpoint");
//    Topic newTopic = iTopicService.createANewTopic(createTopicRequestDto);
//    log.info("Ending topic creation endpoint");
//    return new ResponseEntity<>(newTopic, HttpStatus.OK);

    return null;
  }

}
