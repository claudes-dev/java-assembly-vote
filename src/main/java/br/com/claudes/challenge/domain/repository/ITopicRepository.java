package br.com.claudes.challenge.domain.repository;

import br.com.claudes.challenge.domain.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITopicRepository extends JpaRepository<Topic, Long> {

}
