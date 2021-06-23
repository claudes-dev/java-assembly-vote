package br.com.claudes.challenge.service;

import br.com.claudes.challenge.dto.session.CreateSessionRequestDto;
import br.com.claudes.challenge.model.Session;

import java.util.List;

public interface ISessionService {

  /**
   *
   * @param createSessionRequestDto
   * @return
   */
  Session createSession(CreateSessionRequestDto createSessionRequestDto);

  /**
   *
   * @return
   */
  List<Session> getAllSessions();
}
