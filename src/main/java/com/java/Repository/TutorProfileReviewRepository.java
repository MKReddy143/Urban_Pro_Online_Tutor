package com.java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.Model.TutorProfileReview;

@Repository
public interface TutorProfileReviewRepository extends JpaRepository<TutorProfileReview, Integer> {

}
