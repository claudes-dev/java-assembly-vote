package br.com.claudes.challenge.domain.dto.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericErrorMessageDto {

  private LocalDateTime currentDate;

  private String title;

  private String detail;

  private String developerMessage;

  private int statusCode;

}
