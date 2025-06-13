package com.lhw.reviewmanagement.service;

import com.lhw.reviewmanagement.Entity.Review;
import com.lhw.reviewmanagement.dto.ReviewDTO;
import com.lhw.reviewmanagement.dto.ReviewResponseDTO;
import com.lhw.reviewmanagement.repository.ReviewRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;


    public ReviewResponseDTO saveReview(ReviewDTO reviewDTO) {
        Review review = Review.builder()
                .name(reviewDTO.getName())
                .comment(reviewDTO.getComment())
                .build();
        Review saved = reviewRepository.save(review);
        return new ReviewResponseDTO(saved);
    }
    @Transactional
    public ReviewResponseDTO updateReview(ReviewDTO reviewDTO,Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("전에 등록하신 리뷰가 없습니다."));

        review.setComment(reviewDTO.getComment());

        return new ReviewResponseDTO(reviewRepository.save(review));
    }
}
