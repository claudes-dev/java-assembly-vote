package br.com.claudes.challenge.service;

import br.com.claudes.challenge.domain.dto.topic.CreateTopicRequestDto;
import br.com.claudes.challenge.domain.model.Topic;

import java.util.List;

public interface ITopicService {

  /**
   * create a net topic
   *
   * @param createTopicRequestDto
   * @return Topic
   */
  public Topic createANewTopic(CreateTopicRequestDto createTopicRequestDto);

  /**
   * get all topics
   *
   * @return list of topics
   */
  public List<Topic> getAllTopics();
}
