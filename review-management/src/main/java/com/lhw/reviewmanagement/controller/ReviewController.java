package com.lhw.reviewmanagement.controller;


import com.lhw.reviewmanagement.Entity.Review;
import com.lhw.reviewmanagement.dto.ReviewDTO;
import com.lhw.reviewmanagement.dto.ReviewResponseDTO;
import com.lhw.reviewmanagement.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private  final ReviewService reviewService;

    @GetMapping("/my")
    public ResponseEntity<List<ReviewResponseDTO>> getMyReview(@RequestHeader("X-User-Id") String userId)
    {
        List<ReviewResponseDTO> reviews = reviewService.getReviewByUserId(userId);
        return ResponseEntity.ok(reviews);
    }


    @PostMapping
    public ResponseEntity<ReviewResponseDTO> createReview(
            @RequestBody ReviewDTO reviewDTO,
            @RequestHeader("X-User-Id") String userId
    ) {
        return ResponseEntity.ok(reviewService.saveReview(reviewDTO, userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponseDTO> updateReview(
            @PathVariable Long id,
            @RequestBody ReviewDTO reviewDTO
    ) {
        ReviewResponseDTO updated = reviewService.updateReview(reviewDTO,id);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteReview(
            @RequestHeader ("X-User-Id") String userId,
            @RequestBody DeleteReviewRequest request
    ) {
        reviewService.deleteReview(userId,request.getScheduleId());
        return ResponseEntity.noContent().build();
    }
}
