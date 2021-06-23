package br.com.claudes.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_PAUTA")
public class Topic {

  public Topic(String title,String description){
    this.title = title;
    this.description = description;
  }

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long topicId;

  private String title;

  private String description;

  @JsonIgnore
  @OneToOne(mappedBy = "topicVoting")
  private Session session;

}
