package br.com.claudes.challenge.service;

import br.com.claudes.challenge.domain.dto.topic.CreateTopicRequestDto;
import br.com.claudes.challenge.domain.model.Session;
import br.com.claudes.challenge.domain.model.Topic;
import br.com.claudes.challenge.domain.repository.ITopicRepository;
import br.com.claudes.challenge.service.impl.TopicServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TopicServiceImplTest {

  @InjectMocks
  private ITopicService iTopicService = new TopicServiceImpl();

  @Mock(answer = Answers.RETURNS_SMART_NULLS)
  private ITopicRepository topicRepository;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void createANewTopicTest(){

    CreateTopicRequestDto createTopicRequestDto = new CreateTopicRequestDto();
    createTopicRequestDto.setTitle("dummyTitle");
    createTopicRequestDto.setDescription("dummyDescription");

    when(topicRepository.save(any(Topic.class))).thenReturn(new Topic());

    Topic topic = iTopicService.createANewTopic(createTopicRequestDto);

    assertThat(topic).isNotNull();

  }

  @Test
  public void getAllSessionsTest(){

    List<Topic> topicList = new ArrayList<>();

    when(topicRepository.findAll()).thenReturn(topicList);

    List<Topic> topics = iTopicService.getAllTopics();

    assertThat(topics).isNotNull();

  }

}
