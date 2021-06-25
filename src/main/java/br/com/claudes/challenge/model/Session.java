package br.com.claudes.challenge.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
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

  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  private LocalDateTime startingVoting;

  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  private LocalDateTime finalVoting;

  @OneToMany(mappedBy = "session")
  private List<Vote> vote;

}
