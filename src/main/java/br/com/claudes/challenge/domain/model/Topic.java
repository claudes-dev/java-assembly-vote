package br.com.claudes.challenge.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_PAUTA")
public class Topic {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long topicId;

  private String title;

  private String description;

  @JsonIgnore
  @OneToOne(mappedBy = "topicVoting")
  private Session session;

}
