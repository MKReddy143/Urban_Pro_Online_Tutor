package com.java.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "demo_Video")
public class demoVideo {

	@Id
	private String email;
	private String videoPath;
	private String title;
	@Column(columnDefinition = "TEXT")
	private String description;
	private String skills;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public demoVideo(String email, String videoPath, String title, String description, String skills) {
		super();
		this.email = email;
		this.videoPath = videoPath;
		this.title = title;
		this.description = description;
		this.skills = skills;
	}

	public demoVideo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "demoVideo [email=" + email + ", videoPath=" + videoPath + ", title=" + title + ", description="
				+ description + ", skills=" + skills + "]";
	}
}
