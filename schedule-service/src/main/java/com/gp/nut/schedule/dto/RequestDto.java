package com.gp.nut.schedule.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class RequestDto {

  @NotNull(message = "회식을 주최하는 사장 ID는  필수입니다.")
  private Long bossId;

  @NotNull(message = "회식 날짜는 필수입니다.")
  private LocalDate Date;

  @NotEmpty(message = "참여자 ID 목록은 비어있을 수 없습니다.") // null과 빈 리스트를 실패 처리
  private List<Long> participantIds;

  @NotEmpty(message = "회식 장소 후보 ID 목록은 비어있을 수 없습니다.") // null과 빈 리스트를 실패 처리
  private List<Long> candidateLocationIds;

  private Long confirmedLocationId; // 확정 장소는 없어도 회식 생성 가능

}
