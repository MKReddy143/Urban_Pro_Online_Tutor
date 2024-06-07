package com.java.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.Model.TutorProfileReview;
import com.java.Services.TutorProfileReviewService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/reviews")
public class ProfileReviews {

	private TutorProfileReviewService reviews;

	public ProfileReviews(TutorProfileReviewService reviews) {
		super();
		this.reviews = reviews;
	}

	@PostMapping("/add")
	public ResponseEntity<String> AddReview(@RequestBody TutorProfileReview review) {
		reviews.addReview(review);
		return ResponseEntity.ok("success");
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<List<TutorProfileReview>> getMethodName(@PathVariable String email) {
		return ResponseEntity.ok(reviews.getAllReviews(email));
	}

	@GetMapping("average/{email}")
	public ResponseEntity<Float> getAverageReview(@PathVariable String email) {
		return ResponseEntity.ok(reviews.AverageReview(email));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deletereview(@RequestBody TutorProfileReview rev) {
		reviews.deleteReview(rev.getFromemail(), rev.getToemail());
		return ResponseEntity.ok("succesfully deleted");
	}
}
