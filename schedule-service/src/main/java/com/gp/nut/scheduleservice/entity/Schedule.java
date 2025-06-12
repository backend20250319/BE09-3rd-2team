package com.gp.nut.scheduleservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Schedule {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id; // pk

  @Column(nullable = false)
  private Long bossId; // 회식 만든 사장의 id

  @Column(nullable = false)
  private LocalDate dinnerDate; // 회식 날짜

  private Long confirmedLocationId; // 확정 회식 장소

  @NotEmpty // 컬렉션이 빈값이 아닌지 체크
  @ElementCollection // 기본값이나 임베디드 타입의 컬렉션을 별도 테이블에 매핑
  private List<Long> participantIds; // 참여 사원들

  @NotEmpty
  @ElementCollection
  private  List<Long> candidateLocationIds; // 회식 장소 후보 목록들

}
