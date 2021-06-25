package br.com.claudes.challenge.service;

import br.com.claudes.challenge.dto.vote.CountVotesResponseDto;
import br.com.claudes.challenge.dto.vote.CreateVoteRequestDto;
import br.com.claudes.challenge.model.Vote;

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
