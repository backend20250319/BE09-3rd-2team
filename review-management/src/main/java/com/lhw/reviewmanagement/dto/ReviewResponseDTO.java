package com.lhw.reviewmanagement.dto;

import com.lhw.reviewmanagement.Entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewResponseDTO{
    private Long  reviewId ;
    private String comment;

    public ReviewResponseDTO(Review review){
        this.reviewId = review.getReviewId();
        this.comment = review.getComment();
    }

}
