package br.com.claudes.challenge.domain.dto.vote;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountVotesResponseDto {

  private Long numberOfNegativeVotes;

  private Long numberOfPositiveVotes;

  private Long totalVotes;

  private String message;

}
