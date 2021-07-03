package br.com.claudes.challenge.service;

import br.com.claudes.challenge.domain.dto.session.CreateSessionRequestDto;
import br.com.claudes.challenge.domain.model.Session;

import java.util.List;

public interface ISessionService {

  /**
   * create a session
   *
   * @param createSessionRequestDto
   * @return Session
   */
  Session createSession(CreateSessionRequestDto createSessionRequestDto);

  /**
   * get all sessions
   *
   * @return list of sessions
   */
  List<Session> getAllSessions();
}
