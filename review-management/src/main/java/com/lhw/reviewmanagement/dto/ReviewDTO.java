package com.lhw.reviewmanagement.dto;

import com.lhw.reviewmanagement.Entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewDTO {
    private Long reviewId;
    private Long  scheduleId;   // schedule 테이블 고유 Id
    private Long userId ;     // user 테이블 고유 Id
    private String username ;    // 리뷰 작성자 Id
    private String comment;     // 리뷰 내용


}
