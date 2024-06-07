package com.java.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.Model.TutorProfileReview;
import com.java.Repository.TutorProfileReviewRepository;

@Service
public class TutorProfileReviewService {

	@Autowired
	private TutorProfileReviewRepository repo;

	public void addReview(TutorProfileReview review) {
		repo.save(review);
	}

	public List<TutorProfileReview> getAllReviews(String email) {
		List<TutorProfileReview> all = repo.findAll();
		List<TutorProfileReview> review = new ArrayList<>();
		for (TutorProfileReview list : all) {
			if (list.getToemail().equals(email)) {
				review.add(list);
			}
		}
		return review;
	}

	public float AverageReview(String email) {
		float avg = 0;
		int count = 0;
		List<TutorProfileReview> list = getAllReviews(email);
		for (TutorProfileReview all : list) {
			avg += all.getRating();
			count++;
		}
		return avg / count;
	}

	public void deleteReview(String fromemail, String toemail) {
		List<TutorProfileReview> all = repo.findAll();
		for (TutorProfileReview list : all) {
			if (list.getFromemail().equals(fromemail) && list.getToemail().equals(toemail)) {
				repo.deleteById(list.getId());
			}
		}
	}
}
