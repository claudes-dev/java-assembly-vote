package br.com.claudes.challenge.domain.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_SESSAO")
public class Session {

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
