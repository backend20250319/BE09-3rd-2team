package com.gp.nut.scheduleservice.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseDto {

  private Long id; // 어떤 스케줄인지 알기 위해 필요
  private Long bossId;
  private LocalDate dinnerDate;
  private Long confirmedLocationId;
  private List<Long> participantIds;
  private List<Long> candidateLocationIds;
}
