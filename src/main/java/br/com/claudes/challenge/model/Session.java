package br.com.claudes.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_SESSAO")
public class Session {

  public Session(Topic topicVoting, LocalDateTime startingVoting, LocalDateTime finalVoting){
    this.topicVoting = topicVoting;
    this.startingVoting = startingVoting;
    this.finalVoting = finalVoting;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long sessionId;

  @OneToOne()
  @JoinColumn(name = "topicId")
  private Topic topicVoting;

  private LocalDateTime startingVoting;

  private LocalDateTime finalVoting;

  @OneToMany(mappedBy = "session")
  private List<Vote> vote;

}
