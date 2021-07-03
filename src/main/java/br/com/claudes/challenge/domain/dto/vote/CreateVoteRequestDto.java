package br.com.claudes.challenge.domain.dto.vote;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateVoteRequestDto {

  private String document;

  private Boolean vote;

  private Long sessionId;
}
