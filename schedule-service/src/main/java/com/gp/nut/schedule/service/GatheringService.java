package com.gp.nut.schedule.service;

import com.gp.nut.schedule.dto.GatheringRequestDto;
import com.gp.nut.schedule.dto.GatheringResponseDto;
import com.gp.nut.schedule.dto.UpdateConfirmedLocationDto;
import com.gp.nut.schedule.dto.UpdateDateRequestDto;
import com.gp.nut.schedule.entity.Gathering;
import com.gp.nut.schedule.repository.GatheringRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/* 서비스는 비즈니스 로직을 담당한다.
 * entity -> response/resquest 또는 그 반대로 변환하는 로직을 포함한다.
 * db에 직접 접근하는 로직이 포함되므로 @Transaction어노테이션은 서비스에 붙인다.
 * 단순조회는 생략이 가능하고, 읽기 전용이면 @Transcational(readOnly = true)를 붙인다. */

@Service
@RequiredArgsConstructor
public class GatheringService {

  private final GatheringRepository gatheringRepository;

  // Gathering 등록(보스, 날짜, 참여사원, 회식장소 후보들)
  @Transactional
  public GatheringResponseDto createGathering(GatheringRequestDto requestDto) {
    Gathering savedGathering = gatheringRepository.save(requestDto.toGathering());
    return savedGathering.toResponseDto();
  }

  // Gathering 날짜 변경
  @Transactional
  public GatheringResponseDto updateGatheringDate(UpdateDateRequestDto requestDto) {
    Gathering retrieveGathering = gatheringRepository.findById(requestDto.getId()).orElseThrow(
        // EntityNotFoundException: 존재하지 않는 자원 처리
        // IllegalArgumentException(잘못된 인자, 존재하지 않는 자원 요청) 보다 더 직관적
        () -> new EntityNotFoundException(
            "해당 회식은 존재하지 않습니다. ID: " + requestDto.getId()));
    retrieveGathering.updateDate(requestDto.getDate()); // 찾은 회식의 날짜 변경

    Gathering updatedGathering = gatheringRepository.save(retrieveGathering); // db 반영
    return updatedGathering.toResponseDto();
  }




}
