package br.com.claudes.challenge.dto.session;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateSessionRequestDto {

  private Long topicVotingId;

  private LocalDateTime finalDateVoting;
}
