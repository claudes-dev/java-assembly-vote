package br.com.claudes.challenge.controller;

import br.com.claudes.challenge.domain.dto.vote.CountVotesResponseDto;
import br.com.claudes.challenge.domain.dto.vote.CreateVoteRequestDto;
import br.com.claudes.challenge.domain.model.Vote;
import br.com.claudes.challenge.service.IVoteService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController()
@RequestMapping("vote-management/v1")
public class VoteController {

  @Autowired
  private IVoteService iVoteService;

  @PostMapping(value = "/vote", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "API used to insert a vote in the session")
  public ResponseEntity<Vote> insertAVote(@RequestBody CreateVoteRequestDto createVoteRequestDto){

    log.info("Starting Vote creation endpoint");
    Vote newVote = iVoteService.insertAVote(createVoteRequestDto);
    log.info("Ending Vote creation endpoint");

    return new ResponseEntity<>(newVote, HttpStatus.CREATED);
  }


  @GetMapping(value = "/vote", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "API used to count votes in the session")
  public ResponseEntity<CountVotesResponseDto> countVotes(@RequestParam("sessionId") Long sessionId){

    log.info("Starting Vote creation endpoint");
    CountVotesResponseDto countVotes = iVoteService.countVotes(sessionId);
    log.info("Ending Vote creation endpoint");

    return new ResponseEntity<>(countVotes, HttpStatus.OK);
  }
}
