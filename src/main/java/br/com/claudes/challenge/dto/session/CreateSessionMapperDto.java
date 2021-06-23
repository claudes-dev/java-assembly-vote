package br.com.claudes.challenge.dto.session;

import br.com.claudes.challenge.model.Session;
import br.com.claudes.challenge.model.Topic;

import java.time.LocalDateTime;

public class CreateSessionMapperDto {

  private CreateSessionMapperDto(){
    throw new IllegalStateException("Utility class");
  }

  public static Session createToEntity(Topic topic, CreateSessionRequestDto createTopicRequestDto){

    LocalDateTime startingSession = LocalDateTime.now();

    if(createTopicRequestDto.getFinalDateVoting() != null){
      return new Session(topic, startingSession , createTopicRequestDto.getFinalDateVoting());
    }

    return new Session(topic, startingSession , startingSession.plusMinutes(1));

  }
}
