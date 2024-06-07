package com.java.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.java.Model.demoVideo;
import com.java.Services.demoVideoService;

@RestController
@RequestMapping("/demo_video")
public class Tutor_Demo_Video_Controller {

	private demoVideoService service;

	public Tutor_Demo_Video_Controller(demoVideoService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<demoVideo>> get_All_demos() {
		List<demoVideo> all = service.getAll();
		return new ResponseEntity<>(all, HttpStatus.OK);
	}

	@PostMapping("/Upload")
	public ResponseEntity<String> VideoUpload(@RequestParam("email") String email, @RequestParam("title") String title,
			@RequestParam("skills") String skills, @RequestParam("description") String description,
			@RequestParam("video") MultipartFile video) throws IllegalStateException, IOException {
		String videoPath = System.getProperty("user.dir") + "/uploads" + video.getOriginalFilename();
		video.transferTo(new File(videoPath));
		demoVideo demoVideo = new demoVideo();
		demoVideo.setTitle(title);
		demoVideo.setDescription(description);
		demoVideo.setEmail(email);
		demoVideo.setSkills(skills);
		demoVideo.setVideoPath(videoPath);
		service.saveDemo(demoVideo);
		return new ResponseEntity<>("successfully saved demo video", HttpStatus.OK);
	}

}
