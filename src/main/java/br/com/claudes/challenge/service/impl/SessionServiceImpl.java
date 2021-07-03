package br.com.claudes.challenge.service.impl;

import br.com.claudes.challenge.domain.constants.TopicConstants;
import br.com.claudes.challenge.domain.dto.session.CreateSessionRequestDto;
import br.com.claudes.challenge.domain.model.Session;
import br.com.claudes.challenge.domain.model.Topic;
import br.com.claudes.challenge.domain.repository.ISessionRepository;
import br.com.claudes.challenge.domain.repository.ITopicRepository;
import br.com.claudes.challenge.handler.exceptions.ResourceNotFoundException;
import br.com.claudes.challenge.service.ISessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SessionServiceImpl implements ISessionService {

  @Autowired
  private ISessionRepository iSessionRepository;

  @Autowired
  private ITopicRepository iTopicRepository;

  @Override
  public Session createSession(CreateSessionRequestDto createSessionRequestDto) {
    log.info("Find topic by ID {}", createSessionRequestDto.getTopicVotingId());
    Optional<Topic> optionalTopic = iTopicRepository.findById(createSessionRequestDto.getTopicVotingId());
    Session session = new Session();

    if(optionalTopic.isPresent()){
      log.info("Create session");
      LocalDateTime localDateTimeSession = LocalDateTime.now();

      Session createSession = Session.builder()
              .topicVoting(optionalTopic.get())
              .startingVoting(localDateTimeSession)
              .finalVoting(getFinalVoting(createSessionRequestDto, localDateTimeSession))
              .build();

      session = iSessionRepository.save(createSession);
    }else{
      throw new ResourceNotFoundException(TopicConstants.TOPIC_NOT_FOUND);
    }

    return session;
  }

  @Override
  public List<Session> getAllSessions() {
    return iSessionRepository.findAll();
  }

  private LocalDateTime getFinalVoting(CreateSessionRequestDto createSessionRequestDto, LocalDateTime localDateTimeSession) {
    return createSessionRequestDto.getFinalDateVoting() != null
            ? createSessionRequestDto.getFinalDateVoting() : localDateTimeSession.plusMinutes(1l);
  }
}
