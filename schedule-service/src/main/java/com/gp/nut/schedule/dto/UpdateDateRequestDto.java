package com.gp.nut.schedule.dto;

import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
/* 스프링 부트 기본 설정에서는 @RequestBody로 받을 때
기본 생성자 + setter 있어야 문제 없이 매핑된다. json객체를 역직렬화 해야하기 때문이다. */
@Setter
@ToString
@Builder
public class UpdateDateRequestDto {
  @NotEmpty // @NotEmpty 어노테이션은 null과 빈 값 둘 다 검사한다.
  Long id;

  @NotEmpty
  LocalDate date;
}
