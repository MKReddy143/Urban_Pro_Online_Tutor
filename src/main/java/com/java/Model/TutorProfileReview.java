package com.java.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tutor_Profile_Review")
public class TutorProfileReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fromemail;
	private String toemail;
	private String review;
	private int rating;

	public TutorProfileReview(int id, String fromemail, String toemail, String review, int rating) {
		super();
		this.id = id;
		this.fromemail = fromemail;
		this.toemail = toemail;
		this.review = review;
		this.rating = rating;
	}

	public TutorProfileReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TutorProfileReview [id=" + id + ", fromemail=" + fromemail + ", toemail=" + toemail + ", review="
				+ review + ", rating=" + rating + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromemail() {
		return fromemail;
	}

	public void setFromemail(String fromemail) {
		this.fromemail = fromemail;
	}

	public String getToemail() {
		return toemail;
	}

	public void setToemail(String toemail) {
		this.toemail = toemail;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
