package com.gp.nut.schedule.service;

import com.gp.nut.schedule.dto.GatheringRequestDto;
import com.gp.nut.schedule.dto.GatheringResponseDto;
import com.gp.nut.schedule.dto.UpdateConfirmedLocationDto;
import com.gp.nut.schedule.dto.UpdateDateRequestDto;
import com.gp.nut.schedule.entity.Gathering;
import com.gp.nut.schedule.repository.GatheringRepository;
import com.gp.nut.schedule.security.SecurityUtil;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

  // Gathering에 확정된 회식정보 저장
  @Transactional
  public GatheringResponseDto updateConfirmedLocation(UpdateConfirmedLocationDto requestDto) {
    Gathering retrieveGathering = gatheringRepository.findById(requestDto.getId()).orElseThrow(
        () -> new EntityNotFoundException(
            "해당 회식은 존재하지 않습니다. ID: " + requestDto.getId()
        )
    );
    retrieveGathering.updateConfirmedLocationId(requestDto.getConfirmedLocationId());
    Gathering updatedGathering = gatheringRepository.save(retrieveGathering);
    return updatedGathering.toResponseDto();
  }

  // Gathering 삭제
  @Transactional
  public void deleteGathering(Long id) {
    String currentUserId = SecurityUtil.getCurrentUserId();

    Gathering gathering = gatheringRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("회식을 찾을 수 없습니다."));

    boolean isOwner = gathering.getBossId().equals(Long.valueOf(currentUserId));

    /*boolean isAdmin = role.equals("ADMIN");
    boolean isAdmin = true;

    if (!isOwner && !isAdmin) { // 회식을 만든 사장이 아니거나 관리자가 아니면 삭제할 수 없다.
      throw new AccessDeniedException("삭제 권한이 없습니다.");
    }*/
    if(!isOwner) {
      throw new AccessDeniedException("삭제 권한이 없습니다.");
    }

    gatheringRepository.delete(gathering);
  }

  // 모든 회식 정보 조회하기
  @Transactional(readOnly = true)
  public List<GatheringResponseDto> findAllGatherings() {
    List<GatheringResponseDto> gatheringList =
        gatheringRepository.findAll().stream().map(Gathering::toResponseDto).toList();
    return gatheringList;
  }

  // 회식 id로 회식 정보 조회하기
  @Transactional(readOnly = true)
  public GatheringResponseDto findById(Long id) {
    Gathering retrieveGathering = gatheringRepository.findById(id).orElseThrow(
        () -> new EntityNotFoundException(" 해당 회식은 존재하지 않습니다. ID: " + id)
    );
    return retrieveGathering.toResponseDto();
  }

  // 날짜로 회식 정보 조회하기
  @Transactional(readOnly = true)
  public List<GatheringResponseDto> findByDate(LocalDate date) {
    List<GatheringResponseDto> gatheringList = gatheringRepository.findGatheringByDate(date).stream().map(Gathering::toResponseDto).toList();
    return gatheringList;
  }

  // 만든 사장으로 회식 정보 조회하기
  public List<GatheringResponseDto> findByBossId(Long bossId) {
    List<GatheringResponseDto> gatheringList = gatheringRepository.findGatheringByBossId(bossId).stream().map(Gathering::toResponseDto).toList();
    return gatheringList;
  }

}
