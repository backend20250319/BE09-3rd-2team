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

    @PostMapping
    public ResponseEntity<ReviewResponseDTO> createReview(@RequestBody ReviewDTO reviewDTO) {
        ReviewResponseDTO saved = reviewService.saveReview(reviewDTO);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponseDTO> updateReview(
            @PathVariable Long id,
            @RequestBody ReviewDTO reviewDTO
    ) {
        ReviewResponseDTO updated = reviewService.updateReview(reviewDTO,id);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        ReviewResponseDTO deleted = reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
