package br.com.claudes.challenge.controller;

import br.com.claudes.challenge.dto.vote.CountVotesResponseDto;
import br.com.claudes.challenge.dto.vote.CreateVoteRequestDto;
import br.com.claudes.challenge.model.Vote;
import br.com.claudes.challenge.service.IVoteService;
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

@WebMvcTest(controllers = VoteController.class)
public class VoteControllerTest {

  private static final String APPROVED_TOPIC = "Pauta aprovada!";

  private static final String REJECTED_TOPIC = "Pauta rejeitada!";

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private IVoteService iVoteService;

  @Test
  public void insertVotSuccess() throws Exception {
    CreateVoteRequestDto createVoteRequestDto = new CreateVoteRequestDto();
    createVoteRequestDto.setVote(true);
    createVoteRequestDto.setSessionId(1l);
    createVoteRequestDto.setDocument("12345678901");

    Vote vote = new Vote();
    vote.setVote(true);
    vote.setVoteId(1l);
    vote.setDocument("12345678901");

    when(iVoteService.insertAVote(createVoteRequestDto)).thenReturn(vote);

    mockMvc.perform(MockMvcRequestBuilders.post("/vote-management/v1/vote")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .accept(MediaType.APPLICATION_JSON_VALUE)
            .content(JsonUtils.toJson(createVoteRequestDto)))
            .andExpect(status().isCreated());

  }

  @Test
  public void countVotesSuccess() throws Exception {
    CountVotesResponseDto countVotesResponseDto = new CountVotesResponseDto();
    countVotesResponseDto.setTotalVotes(4l);
    countVotesResponseDto.setNumberOfPositiveVotes(3l);
    countVotesResponseDto.setNumberOfNegativeVotes(1l);
    countVotesResponseDto.setMessage(APPROVED_TOPIC);

    when(iVoteService.countVotes(1l)).thenReturn(countVotesResponseDto);
    
    mockMvc.perform(MockMvcRequestBuilders.get("/vote-management/v1/vote?sessionId=1"))
            .andExpect(status().isOk());

  }
}
