package br.com.claudes.challenge.service.impl;

import br.com.claudes.challenge.dto.topic.CreateTopicMapperDto;
import br.com.claudes.challenge.dto.topic.CreateTopicRequestDto;
import br.com.claudes.challenge.model.Topic;
import br.com.claudes.challenge.repository.ITopicRepository;
import br.com.claudes.challenge.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements ITopicService {

  @Autowired
  private ITopicRepository topicRepository;

  public TopicServiceImpl(ITopicRepository topicRepository) {
    this.topicRepository = topicRepository;
  }

  @Override
  public Topic createANewTopic(CreateTopicRequestDto createTopicRequestDto) {

    return topicRepository.save(CreateTopicMapperDto.createToEntity(createTopicRequestDto));
  }

  @Override
  public List<Topic> getAllTopics() {
    return topicRepository.findAll();
  }
}
