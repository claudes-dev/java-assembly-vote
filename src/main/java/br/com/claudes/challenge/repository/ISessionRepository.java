package br.com.claudes.challenge.repository;

import br.com.claudes.challenge.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISessionRepository extends JpaRepository<Session, Long> {

}
