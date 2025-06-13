package com.gp.nut.schedule.controller;

import com.gp.nut.schedule.dto.GatheringRequestDto;
import com.gp.nut.schedule.dto.GatheringResponseDto;
import com.gp.nut.schedule.dto.UpdateDateRequestDto;
import com.gp.nut.schedule.service.GatheringService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* 컨트롤러는 외부 요청 수신, 응답 반환한다.
*  따라서 dto만 갖고있어야한다. */

@Tag(name = "예제 API", description = "Swagger 테스트용 API") // 스웨거용
@RestController // springweb 의존성 추가해야함
@RequestMapping("/goodplace/schedule")
@RequiredArgsConstructor
public class GatheringController {
  private final GatheringService gatheringService;


  // Gathering 등록(보스, 날짜, 참여사원, 회식장소 후보들)
  @PostMapping("/gathering")
  // 입력데이터의 유효성 검사는 컨트롤러에서 한다. (@Valid)
  public GatheringResponseDto createGathering(@RequestBody @Valid GatheringRequestDto requestDto) {
    return gatheringService.createGathering(requestDto);
  }

  // Gathering 날짜 변경
  @PutMapping("/gathering/date")
  public GatheringResponseDto gatheringDate(@RequestBody UpdateDateRequestDto requestDto) {
    return gatheringService.updateGatheringDate(requestDto);
  }

  // Gathering에 확정된 회식정보 저장

  // Gathering 삭제
}
