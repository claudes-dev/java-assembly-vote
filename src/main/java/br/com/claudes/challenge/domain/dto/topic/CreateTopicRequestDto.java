package br.com.claudes.challenge.domain.dto.topic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTopicRequestDto {

  private String title;

  private String description;

}
