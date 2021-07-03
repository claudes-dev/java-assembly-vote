package br.com.claudes.challenge.controller;

import br.com.claudes.challenge.domain.dto.session.CreateSessionRequestDto;
import br.com.claudes.challenge.domain.model.Session;
import br.com.claudes.challenge.service.ISessionService;
import br.com.claudes.challenge.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SessionController.class)
public class SessionControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ISessionService iSessionService;

  @Test
  public void testeCreateSessionWithSucess() throws Exception {
    LocalDateTime localDateTime = LocalDateTime.now();
    CreateSessionRequestDto createSessionRequestDto = new CreateSessionRequestDto();

    createSessionRequestDto.setFinalDateVoting(localDateTime.plusHours(1l));
    createSessionRequestDto.setTopicVotingId(1l);

    Session session = new Session();
    session.setSessionId(1l);
    session.setFinalVoting(localDateTime.plusHours(1l));
    session.setStartingVoting(localDateTime);

    when(iSessionService.createSession(createSessionRequestDto)).thenReturn(session);

    mockMvc.perform(MockMvcRequestBuilders.post("/session-management/v1/session")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .accept(MediaType.APPLICATION_JSON_VALUE)
            .content(JsonUtils.toJson(createSessionRequestDto)))
            .andExpect(status().isCreated());
  }

  @Test
  public void getAllSessionsSucess() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/session-management/v1/session"))
            .andExpect(status().isOk());
  }

}
