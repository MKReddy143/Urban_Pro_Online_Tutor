package com.java.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.Model.demoVideo;
import com.java.Repository.demoVideoRepository;

@Service
public class demoVideoService {

	@Autowired
	private demoVideoRepository repo;

	public void saveDemo(demoVideo video) {
		repo.save(video);
	}

	public List<demoVideo> getAll() {
		return repo.findAll();
	}

	public demoVideo getByemail(String email) {
		return repo.findById(email).orElse(null);
	}

	public void updatedemoVideo(String email, demoVideo video) {
		repo.deleteById(email);
		repo.save(video);
	}

	public void deleteById(String email) {
		repo.deleteById(email);
	}

}
