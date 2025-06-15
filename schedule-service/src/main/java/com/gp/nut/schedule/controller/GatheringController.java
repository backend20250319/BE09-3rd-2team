package com.gp.nut.schedule.controller;

import com.gp.nut.schedule.dto.GatheringRequestDto;
import com.gp.nut.schedule.dto.GatheringResponseDto;
import com.gp.nut.schedule.dto.UpdateConfirmedLocationDto;
import com.gp.nut.schedule.dto.UpdateDateRequestDto;
import com.gp.nut.schedule.service.GatheringService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.access.AccessDeniedException;

/* 컨트롤러는 외부 요청 수신, 응답 반환한다.
*  따라서 dto만 갖고있어야한다. */

@Tag(name = "예제 API", description = "Swagger 테스트용 API") // 스웨거용
@Slf4j // 로그 객체 선언
@RestController // springweb 의존성 추가해야함
@RequiredArgsConstructor
@RequestMapping("/gathering")
public class GatheringController {
  private final GatheringService gatheringService;


  // Gathering 등록(보스, 날짜, 참여사원, 회식장소 후보들)
  @PostMapping()
  // 입력데이터의 유효성 검사는 컨트롤러에서 한다. (@Valid)
  public ResponseEntity<GatheringResponseDto> createGathering(@RequestBody @Valid GatheringRequestDto requestDto,
      Authentication authentication) {
    String authenticatedUserId = authentication.getName();  // 헤더에서 설정된 userId 가져오기
    log.info("authenticatedUserId : {}", authenticatedUserId);

    if (Long.valueOf(authenticatedUserId) != requestDto.getBossId()) {
      throw new AccessDeniedException("본인 아이디로만 등록할 수 있습니다.");
    }

    GatheringResponseDto response = gatheringService.createGathering(requestDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  // Gathering 날짜 변경
  @PatchMapping("/date")
  public ResponseEntity<GatheringResponseDto> updateDate(@RequestBody @Valid UpdateDateRequestDto requestDto) {
    // 본인이 만든 회식인지 체크 (구현 필요)
    GatheringResponseDto response = gatheringService.updateGatheringDate(requestDto);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  // Gathering에 확정된 회식정보 저장
  @PatchMapping("/confirm")
  public ResponseEntity<GatheringResponseDto> updateConfirmedLocation(@RequestBody @Valid
      UpdateConfirmedLocationDto requestDto) {
    GatheringResponseDto response = gatheringService.updateConfirmedLocation(requestDto);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  // Gathering 삭제
  @DeleteMapping("/{id}")
  public ResponseEntity<GatheringResponseDto> deleteGathering(@PathVariable Long id) {
    gatheringService.deleteGathering(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 삭제는 NO_CONTENT 반환
  }
}
