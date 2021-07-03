package br.com.claudes.challenge.domain.repository;

import br.com.claudes.challenge.domain.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISessionRepository extends JpaRepository<Session, Long> {

}
