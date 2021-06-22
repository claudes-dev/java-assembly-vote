package br.com.claudes.challenge.service.impl;

import br.com.claudes.challenge.dto.topic.CreateTopicMapperDto;
import br.com.claudes.challenge.dto.topic.CreateTopicRequestDto;
import br.com.claudes.challenge.model.Topic;
import br.com.claudes.challenge.repository.TopicRepository;
import br.com.claudes.challenge.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements ITopicService {

  @Autowired
  private TopicRepository topicRepository;

  @Override
  public Topic createANewTopic(CreateTopicRequestDto createTopicRequestDto) {

    return topicRepository.save(CreateTopicMapperDto.createToEntity(createTopicRequestDto));
  }
}
