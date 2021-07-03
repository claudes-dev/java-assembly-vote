package br.com.claudes.challenge.controller;

import br.com.claudes.challenge.domain.dto.topic.CreateTopicRequestDto;
import br.com.claudes.challenge.domain.model.Topic;
import br.com.claudes.challenge.service.ITopicService;
import br.com.claudes.challenge.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TopicController.class)
public class TopicControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ITopicService iTopicService;

  @Test
  public void createTopicSuccess() throws Exception {
    CreateTopicRequestDto createTopicRequestDto = new CreateTopicRequestDto();
    createTopicRequestDto.setTitle("dummyTitle");
    createTopicRequestDto.setDescription("dummyDescription");

    Topic topic = new Topic();
    topic.setTopicId(1l);
    topic.setDescription("dummyDescription");
    topic.setTitle("dummyTitle");

    when(iTopicService.createANewTopic(createTopicRequestDto)).thenReturn(topic);

    mockMvc.perform(MockMvcRequestBuilders.post("/topic-management/v1/topic")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .accept(MediaType.APPLICATION_JSON_VALUE)
            .content(JsonUtils.toJson(createTopicRequestDto)))
            .andExpect(status().isCreated());
  }

  @Test
  public void getAllTopicsSucess() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/topic-management/v1/topic"))
            .andExpect(status().isOk());
  }

}
