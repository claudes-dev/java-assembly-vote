package br.com.claudes.challenge.service.impl;

import br.com.claudes.challenge.dto.session.CreateSessionMapperDto;
import br.com.claudes.challenge.dto.session.CreateSessionRequestDto;
import br.com.claudes.challenge.model.Session;
import br.com.claudes.challenge.model.Topic;
import br.com.claudes.challenge.repository.ISessionRepository;
import br.com.claudes.challenge.repository.ITopicRepository;
import br.com.claudes.challenge.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements ISessionService {

  @Autowired
  private ISessionRepository iSessionRepository;

  @Autowired
  private ITopicRepository iTopicRepository;

  @Override
  public Session createSession(CreateSessionRequestDto createSessionRequestDto) {
    Optional<Topic> optionalTopic = iTopicRepository.findById(createSessionRequestDto.getTopicVotingId());
    Session session = new Session();

    if(optionalTopic.isPresent()){
      session = CreateSessionMapperDto.createToEntity(optionalTopic.get(), createSessionRequestDto);
    }

    return iSessionRepository.save(session);
  }

  @Override
  public List<Session> getAllSessions() {
    return iSessionRepository.findAll();
  }
}
