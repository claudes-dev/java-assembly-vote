package br.com.claudes.challenge.repository;

import br.com.claudes.challenge.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVoteRepository extends JpaRepository<Vote, Long> {

}
