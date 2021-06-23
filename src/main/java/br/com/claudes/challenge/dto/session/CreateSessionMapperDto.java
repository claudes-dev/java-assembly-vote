package br.com.claudes.challenge.dto.session;

import br.com.claudes.challenge.dto.topic.CreateTopicRequestDto;
import br.com.claudes.challenge.model.Session;
import br.com.claudes.challenge.model.Topic;

import java.time.LocalDateTime;

public class CreateSessionMapperDto {
  public static Session createToEntity(Topic topic, CreateSessionRequestDto createTopicRequestDto){

    Session session = new Session();

    LocalDateTime startingSession = LocalDateTime.now();

    if(createTopicRequestDto.getFinalDateVoting() != null){
      return new Session(topic, startingSession , createTopicRequestDto.getFinalDateVoting());
    }

    return new Session(topic, startingSession , startingSession.plusMinutes(1));

  }
}
