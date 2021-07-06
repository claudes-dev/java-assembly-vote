package br.com.claudes.challenge.service;

import br.com.claudes.challenge.domain.dto.vote.CountVotesResponseDto;
import br.com.claudes.challenge.domain.dto.vote.CreateVoteRequestDto;
import br.com.claudes.challenge.domain.model.Session;
import br.com.claudes.challenge.domain.model.Topic;
import br.com.claudes.challenge.domain.model.Vote;
import br.com.claudes.challenge.domain.repository.ISessionRepository;
import br.com.claudes.challenge.domain.repository.IVoteRepository;
import br.com.claudes.challenge.service.impl.VoteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class VoteServiceImplTest {

  @InjectMocks
  private IVoteService iVoteService = new VoteServiceImpl();

  @Mock(answer = Answers.RETURNS_SMART_NULLS)
  private IVoteRepository iVoteRepository;

  @Mock(answer = Answers.RETURNS_SMART_NULLS)
  private ISessionRepository iSessionRepository;

  private Session session;

  @BeforeEach
  public void setUp() {

    session = Session.builder()
            .sessionId(1l)
            .topicVoting(new Topic())
            .startingVoting(LocalDateTime.now())
            .finalVoting(LocalDateTime.now().plusMinutes(40))
            .build();

    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void insertAVoteSucessTest(){

    CreateVoteRequestDto createVoteRequestDto = new CreateVoteRequestDto();
    createVoteRequestDto.setVote(Boolean.TRUE);
    createVoteRequestDto.setDocument("dummyDocument");
    createVoteRequestDto.setSessionId(1l);

    when(iSessionRepository.findById(anyLong())).thenReturn(Optional.of(session));
    when(iVoteRepository.findByDocumentAndSessionId(anyString(),anyLong())).thenReturn(Optional.empty());

    Vote vote = iVoteService.insertAVote(createVoteRequestDto);

    assertThat(vote).isNotNull();
  }

  @Test
  public void countVotesTest(){

    when(iVoteRepository.findyBySessionId(anyLong())).thenReturn(getVotes());

    CountVotesResponseDto countVotesResponseDto = iVoteService.countVotes(1l);

    assertThat(countVotesResponseDto).isNotNull();

  }

  private List<Vote> getVotes(){
    Vote vote = Vote.builder()
            .vote(Boolean.TRUE)
            .document("dummyDocument")
            .session(new Session())
            .build();

    return Arrays.asList(vote);
  }

}
