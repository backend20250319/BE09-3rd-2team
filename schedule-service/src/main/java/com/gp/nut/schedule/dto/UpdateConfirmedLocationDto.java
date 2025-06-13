package com.gp.nut.schedule.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UpdateConfirmedLocationDto {
  @NotEmpty
  Long id;

  @NotEmpty
  Long confirmedLocationId;
}
