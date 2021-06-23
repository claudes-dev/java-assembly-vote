package br.com.claudes.challenge.service;

import br.com.claudes.challenge.dto.topic.CreateTopicRequestDto;
import br.com.claudes.challenge.model.Topic;

import java.util.List;

public interface ITopicService {

  /**
   *
   * @param createTopicRequestDto
   * @return
   */
  public  Topic createANewTopic(CreateTopicRequestDto createTopicRequestDto);

  /**
   *
   * @return
   */
  List<Topic> getAllTopics();
}
