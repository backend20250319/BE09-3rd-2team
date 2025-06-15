package com.lhw.reviewmanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private Long scheduleId;
    private String userId;
    private String comment;     // 리뷰 내용
}
