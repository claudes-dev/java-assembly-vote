package br.com.claudes.challenge.dto.session;

import br.com.claudes.challenge.model.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateSessionRequestDto {

  private Long topicVotingId;

  private LocalDateTime finalDateVoting;
}
