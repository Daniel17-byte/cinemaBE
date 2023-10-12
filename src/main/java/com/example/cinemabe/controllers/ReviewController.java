package com.example.cinemabe.controllers;

import com.example.cinemabe.models.Review;
import com.example.cinemabe.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.ok().body(reviewService.getAllReviews());
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        return ResponseEntity.ok().body(reviewService.saveReview(review));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Review>> getReviewById(@PathVariable(value = "id") Long reviewId) {
        return ResponseEntity.ok().body(reviewService.getReviewById(reviewId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable(value = "id") Long reviewId, @RequestBody Review reviewDetails) {
        return ResponseEntity.ok().body(reviewService.updateReview(reviewId, reviewDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable(value = "id") Long reviewId) {
        reviewService.deleteReviewById(reviewId);
        return ResponseEntity.ok().build();
    }
}