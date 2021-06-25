package br.com.claudes.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
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
