package br.com.claudes.challenge.repository;

import br.com.claudes.challenge.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IVoteRepository extends JpaRepository<Vote, Long> {

  @Query(value = "SELECT * FROM tb_voto " +
          "WHERE document = ?1  AND session_id = ?2",
          nativeQuery = true)
  public Optional<Vote> findByDocumentAndSessionId(String document, Long sessionId);

  @Query(value = "SELECT * FROM tb_voto voto " +
          "inner join tb_sessao sessao on sessao.session_id = voto.session_id " +
          "WHERE sessao.session_id = ?1 ",
  nativeQuery = true)
  public List<Vote> findyBySessionId(Long sessionId);
}
