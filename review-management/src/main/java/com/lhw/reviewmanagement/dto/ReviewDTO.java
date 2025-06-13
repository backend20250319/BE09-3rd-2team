package com.lhw.reviewmanagement.dto;

import com.lhw.reviewmanagement.Entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewDTO {

    private Long Id ;     // user 테이블에서 가져온 교유 PK  - 사용자 정보
    private String name ;
    private String comment;


}
