package br.com.claudes.challenge.service.impl;

import br.com.claudes.challenge.domain.constants.SessionConstants;
import br.com.claudes.challenge.domain.constants.VoteConstants;
import br.com.claudes.challenge.domain.dto.vote.CountVotesResponseDto;
import br.com.claudes.challenge.domain.dto.vote.CreateVoteRequestDto;
import br.com.claudes.challenge.domain.model.Session;
import br.com.claudes.challenge.domain.model.Vote;
import br.com.claudes.challenge.domain.repository.ISessionRepository;
import br.com.claudes.challenge.domain.repository.IVoteRepository;
import br.com.claudes.challenge.handler.exceptions.ResourceBadRequestException;
import br.com.claudes.challenge.service.IVoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class VoteServiceImpl implements IVoteService {

  @Autowired
  private IVoteRepository iVoteRepository;

  @Autowired
  private ISessionRepository iSessionRepository;

  @Override
  public Vote insertAVote(CreateVoteRequestDto createVoteRequestDto) {
    LocalDateTime currentDate = LocalDateTime.now();
    Vote vote;

    Optional<Session> session = iSessionRepository.findById(createVoteRequestDto.getSessionId());
    log.info("Find session by ID {}", createVoteRequestDto.getSessionId());

    if(session.isPresent() && currentDate.isBefore(session.get().getFinalVoting()) && currentDate.isAfter(session.get().getStartingVoting())){
      Optional<Vote> verificationVote = iVoteRepository.findByDocumentAndSessionId(createVoteRequestDto.getDocument(), createVoteRequestDto.getSessionId());

      if(verificationVote.isPresent()){
        throw new ResourceBadRequestException(VoteConstants.THE_USER_ALREADY_VOTED);
      }else{
        Vote createVote = Vote.builder()
                .vote(createVoteRequestDto.getVote())
                .document(createVoteRequestDto.getDocument())
                .session(session.get())
                .build();
        vote = iVoteRepository.save(createVote);
      }
    }else{
      throw new ResourceBadRequestException(SessionConstants.THE_SESSION_ENDED);
    }


    return vote;
  }

  @Override
  public CountVotesResponseDto countVotes(Long sessionId) {

    CountVotesResponseDto countVotesResponseDto = new CountVotesResponseDto();

    List<Vote> voteList = iVoteRepository.findyBySessionId(sessionId);

    if(!voteList.isEmpty()){
      countVotesResponseDto = CreateResponseToCountVotes(voteList);
    }

    return countVotesResponseDto;
  }

  private CountVotesResponseDto CreateResponseToCountVotes(List<Vote> voteList) {
    CountVotesResponseDto countVotesResponseDto = new CountVotesResponseDto();
    long countNegativeVotes = voteList.stream().filter(vote -> vote.getVote().equals(Boolean.FALSE)).count();
    long countPositiveVotes = voteList.stream().filter(vote -> vote.getVote().equals(Boolean.TRUE)).count();

    countVotesResponseDto.setNumberOfNegativeVotes(countNegativeVotes);
    countVotesResponseDto.setNumberOfPositiveVotes(countPositiveVotes);
    countVotesResponseDto.setTotalVotes(countNegativeVotes + countPositiveVotes);

    if(countPositiveVotes > countNegativeVotes){
      countVotesResponseDto.setMessage(VoteConstants.APPROVED_TOPIC);
    }else{
      countVotesResponseDto.setMessage(VoteConstants.REJECTED_TOPIC);
    }
    return countVotesResponseDto;
  }
}
