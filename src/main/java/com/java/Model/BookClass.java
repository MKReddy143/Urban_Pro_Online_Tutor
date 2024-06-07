package com.java.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Booked_Classes")
public class BookClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String student_email;
	private String tutor_email;
	private String subject;
	private int TotalFee;
	private int BalanceFee;

	public BookClass(Long id, String student_email, String tutor_email, String subject, int totalFee, int balanceFee) {
		super();
		this.id = id;
		this.student_email = student_email;
		this.tutor_email = tutor_email;
		this.subject = subject;
		TotalFee = totalFee;
		BalanceFee = balanceFee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public String getTutor_email() {
		return tutor_email;
	}

	public void setTutor_email(String tutor_email) {
		this.tutor_email = tutor_email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getTotalFee() {
		return TotalFee;
	}

	public void setTotalFee(int totalFee) {
		TotalFee = totalFee;
	}

	public int getBalanceFee() {
		return BalanceFee;
	}

	public void setBalanceFee(int balanceFee) {
		BalanceFee = balanceFee;
	}

	public BookClass() {
		super();
		// TODO Auto-generated constructor stub
	}

}
