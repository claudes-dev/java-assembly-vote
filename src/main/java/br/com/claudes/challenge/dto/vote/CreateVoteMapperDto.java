package br.com.claudes.challenge.dto.vote;

import br.com.claudes.challenge.model.Session;
import br.com.claudes.challenge.model.Vote;

import java.util.Optional;

public class CreateVoteMapperDto {

  private CreateVoteMapperDto(){
    throw new IllegalStateException("Utility class");
  }

  public static Vote createToEntity(Session session, CreateVoteRequestDto createVoteRequestDto){
    return new Vote(session, createVoteRequestDto.getDocument(), createVoteRequestDto.getVote());

  }
}
