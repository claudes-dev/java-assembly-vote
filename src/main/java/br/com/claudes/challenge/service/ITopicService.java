package br.com.claudes.challenge.service;

import br.com.claudes.challenge.dto.topic.CreateTopicRequestDto;
import br.com.claudes.challenge.model.Topic;

public interface ITopicService {

  public  Topic createANewTopic(CreateTopicRequestDto createTopicRequestDto);
}
