package br.com.claudes.challenge.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
  private Long id;

  private String title;

  private String description;

}
