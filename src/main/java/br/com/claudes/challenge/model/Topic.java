package br.com.claudes.challenge.model;

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

  @OneToOne(mappedBy = "topicVoting")
  private Session session;

}
