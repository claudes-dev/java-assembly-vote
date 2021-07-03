package br.com.claudes.challenge.service;

import br.com.claudes.challenge.domain.dto.vote.CountVotesResponseDto;
import br.com.claudes.challenge.domain.dto.vote.CreateVoteRequestDto;
import br.com.claudes.challenge.domain.model.Vote;

public interface IVoteService {

  /**
   * insert a vote in the session
   *
   * @param createVoteRequestDto
   * @return Vote
   */
  public Vote insertAVote(CreateVoteRequestDto createVoteRequestDto);

  /**
   * Count all votes of the session
   *
   * @param sessionId
   * @return the result of the sessuib
   */
  public CountVotesResponseDto countVotes(Long sessionId);
}
