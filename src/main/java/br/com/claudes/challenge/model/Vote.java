package br.com.claudes.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_VOTO")
public class Vote {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long voteId;

  @ManyToOne
  @JoinColumn(name = "sessionId")
  private Session session;

  private String document;

  private Boolean vote;
}
