package br.com.claudes.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageDto {

  private String message;

  private LocalDateTime currentDate;

}
