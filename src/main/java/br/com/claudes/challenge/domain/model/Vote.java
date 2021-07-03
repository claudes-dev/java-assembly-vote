package br.com.claudes.challenge.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_VOTO")
public class Vote {

  public Vote(Session session, String document, Boolean vote) {
    this.session = session;
    this.document = document;
    this.vote = vote;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long voteId;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "sessionId")
  private Session session;

  private String document;

  private Boolean vote;
}
