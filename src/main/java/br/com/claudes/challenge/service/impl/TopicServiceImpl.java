package br.com.claudes.challenge.service.impl;

import br.com.claudes.challenge.domain.dto.topic.CreateTopicRequestDto;
import br.com.claudes.challenge.domain.model.Topic;
import br.com.claudes.challenge.domain.repository.ITopicRepository;
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

    Topic createTopic = Topic.builder()
            .title(createTopicRequestDto.getTitle())
            .description(createTopicRequestDto.getDescription())
            .build();

    return topicRepository.save(createTopic);
  }

  @Override
  public List<Topic> getAllTopics() {
    return topicRepository.findAll();
  }
}
