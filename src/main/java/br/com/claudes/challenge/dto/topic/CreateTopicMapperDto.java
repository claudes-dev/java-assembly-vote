package br.com.claudes.challenge.dto.topic;

import br.com.claudes.challenge.model.Topic;

public class CreateTopicMapperDto {

  public static Topic createToEntity(CreateTopicRequestDto createTopicRequestDto){
    return new Topic(createTopicRequestDto.getDescription(), createTopicRequestDto.getTitle());

  }
}
