package br.com.claudes.challenge.service.impl;

import br.com.claudes.challenge.dto.vote.CountVotesResponseDto;
import br.com.claudes.challenge.dto.vote.CreateVoteMapperDto;
import br.com.claudes.challenge.dto.vote.CreateVoteRequestDto;
import br.com.claudes.challenge.model.Session;
import br.com.claudes.challenge.model.Vote;
import br.com.claudes.challenge.repository.ISessionRepository;
import br.com.claudes.challenge.repository.IVoteRepository;
import br.com.claudes.challenge.service.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class VoteServiceImpl implements IVoteService {

  private static final String APPROVED_TOPIC = "Pauta aprovada!";

  private static final String REJECTED_TOPIC = "Pauta rejeitada!";

  @Autowired
  private IVoteRepository iVoteRepository;

  @Autowired
  private ISessionRepository iSessionRepository;

  @Override
  public Vote insertAVote(CreateVoteRequestDto createVoteRequestDto) {
    LocalDateTime currentDate = LocalDateTime.now();
    Vote vote = new Vote();
    Optional<Session> session = iSessionRepository.findById(createVoteRequestDto.getSessionId());

    if(session.isPresent() && currentDate.isBefore(session.get().getFinalVoting()) && currentDate.isAfter(session.get().getStartingVoting())){
      Optional<Vote> verificationVote = iVoteRepository.findByDocumentAndSessionId(createVoteRequestDto.getDocument(), createVoteRequestDto.getSessionId());

      if(!verificationVote.isPresent()){
        vote = iVoteRepository.save(CreateVoteMapperDto.createToEntity(session.get(), createVoteRequestDto));
      }
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
      countVotesResponseDto.setMessage(APPROVED_TOPIC);
    }else{
      countVotesResponseDto.setMessage(REJECTED_TOPIC);
    }
    return countVotesResponseDto;
  }
}
