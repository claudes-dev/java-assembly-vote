package br.com.claudes.challenge.service;

import br.com.claudes.challenge.domain.dto.session.CreateSessionRequestDto;
import br.com.claudes.challenge.domain.model.Session;
import br.com.claudes.challenge.domain.model.Topic;
import br.com.claudes.challenge.domain.repository.ISessionRepository;
import br.com.claudes.challenge.domain.repository.ITopicRepository;
import br.com.claudes.challenge.service.impl.SessionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class SessionServiceImplTest {

  @InjectMocks
  private ISessionService iSessionService = new SessionServiceImpl();

  @Mock(answer = Answers.RETURNS_SMART_NULLS)
  private ISessionRepository iSessionRepository;

  @Mock(answer = Answers.RETURNS_SMART_NULLS)
  private ITopicRepository iTopicRepository;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);

  }

  @Test
  public void createSessionTest(){

    CreateSessionRequestDto createSessionRequestDto = new CreateSessionRequestDto();
    createSessionRequestDto.setTopicVotingId(1l);
    createSessionRequestDto.setFinalDateVoting(LocalDateTime.now().plusHours(1));


    Topic topic = Topic.builder()
            .topicId(1l)
            .description("dummyDescription")
            .title("dummyTitle")
            .build();

    Optional<Topic> optionalTopic = Optional.of(topic);

    when(iTopicRepository.findById(anyLong())).thenReturn(optionalTopic);
    when(iSessionRepository.save(any(Session.class))).thenReturn(new Session());

    Session session = iSessionService.createSession(createSessionRequestDto);

    assertThat(session).isNotNull();

  }

  @Test
  public void getAllSessionsTest(){

    List<Session> sessionList = new ArrayList<>();

    when(iSessionRepository.findAll()).thenReturn(sessionList);

    List<Session> sessions = iSessionService.getAllSessions();

    assertThat(sessions).isEqualTo(sessionList);

  }

}
