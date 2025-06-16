package com.lhw.reviewmanagement.service;

import com.lhw.reviewmanagement.Entity.Review;
import com.lhw.reviewmanagement.dto.ReviewDTO;
import com.lhw.reviewmanagement.dto.ReviewResponseDTO;
import com.lhw.reviewmanagement.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;


    public ReviewResponseDTO saveReview(ReviewDTO reviewDTO,String userId) {
        Optional<Review> existing = reviewRepository.findByScheduleIdAndUserId(reviewDTO.getScheduleId(), reviewDTO.getUserId());
        if (existing.isPresent()) {
            throw new IllegalStateException("이미 이 스케줄에 대한 리뷰가 존재합니다.");
        }

        Review review = Review.builder()
                .scheduleId(reviewDTO.getScheduleId())
                .comment(reviewDTO.getComment())
                .userId(userId)
                .build();
        Review saved = reviewRepository.save(review);
        return new ReviewResponseDTO(saved);
    }
    @Transactional
    public ReviewResponseDTO updateReview(ReviewDTO reviewDTO, Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 리뷰가 존재하지 않습니다."));
        review.setComment(reviewDTO.getComment());
        return new ReviewResponseDTO(reviewRepository.save(review));
    }

    @Transactional
    public ReviewResponseDTO deleteReview(String userId,Long scheduleId) {
        Review review = reviewRepository.findByScheduleIdAndUserId(scheduleId,userId)
                .orElseThrow(() -> new NoSuchElementException("해당 리뷰가 존재하지 않습니다."));
        reviewRepository.delete(review);
        return new ReviewResponseDTO(review);
    }

    public List<ReviewResponseDTO> getReviewByUserId(String userId) {
        List<Review> reviewList = reviewRepository.findByUserId(userId);
        return reviewList.stream()
                .map(ReviewResponseDTO::new)
                .collect(Collectors.toList());
    }

}
