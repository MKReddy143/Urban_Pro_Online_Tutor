package com.java.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.java.Model.demoVideo;
import com.java.Services.demoVideoService;

@RestController
@RequestMapping("/video")
public class demoVideoController {

	@Autowired
	private demoVideoService service;

	@GetMapping("/connect")
	public ResponseEntity<String> connect(){
		System.out.println("connected");
		return new ResponseEntity<>("connected",HttpStatus.OK);
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
 
	@GetMapping("/getAll")
	public ResponseEntity<List<demoVideo>> get_All_demos() {
		List<demoVideo> all = service.getAll();
		System.out.println("gjjhgj jhgjh all");
		return new ResponseEntity<>(all, HttpStatus.OK);
	}

	@GetMapping("/getVideo/{videoPath}")
	public ResponseEntity<Resource> get_Video(@PathVariable String file) {
		try {
			Path videoPath = Paths.get(System.getProperty("user.dir") + "/uploads/" + file);
			UrlResource resource = new UrlResource(videoPath.toUri());
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + resource.getFilename() + "\"")
					.body(resource);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

}
