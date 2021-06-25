package br.com.claudes.challenge.dto.vote;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateVoteRequestDto {

  private String document;

  private Boolean vote;

  private Long sessionId;
}
