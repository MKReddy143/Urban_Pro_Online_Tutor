package com.java.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.java.Model.Account;
import com.java.Model.LoginOtp;
import com.java.Model.TutorProfileReview;
import com.java.Model.demoVideo;
import com.java.Services.AccountService;
import com.java.Services.TutorProfileReviewService;
import com.java.Services.demoVideoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class Account_Controller {

	private final AccountService AS;
	private final demoVideoService dvs;
	private final TutorProfileReviewService tprs;

	public Account_Controller(AccountService AS, demoVideoService dvs, TutorProfileReviewService tprs) {
		super();
		this.AS = AS;
		this.dvs = dvs;
		this.tprs = tprs;
	}

//-------------------------------Tutor Profile----------------------------------

	@GetMapping("/get_profile/{email}")
	public ResponseEntity<Account> get_Profile(@PathVariable String email) {
		Account account = AS.getAccount(email);
		System.out.println(email);
		System.out.println("hiiiiii");  
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

	@GetMapping("/get_Tutors")
	public ResponseEntity<List<Account>> getTutorsAccount() {
		return new ResponseEntity<>(AS.getTutorsAccountList(), HttpStatus.OK);
	}

	


//-----------------------------Tutor Demo Videos ---------------------------------------

	@GetMapping("/getAlldemo")
	public ResponseEntity<List<demoVideo>> get_All_demos() {
		List<demoVideo> all = dvs.getAll();
//		System.out.println("gjjhgj jhgjh all");
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
		dvs.saveDemo(demoVideo);
		return new ResponseEntity<>("successfully saved demo video", HttpStatus.OK);
	}

//-------------------------------Login & Registration-----------------------------------

	@GetMapping("/getAll")
	public ResponseEntity<List<Account>> Get_All() {
		return new ResponseEntity<>(AS.GetAllAccounts(), HttpStatus.OK);
	}

	@PostMapping("/register_otp")
	public ResponseEntity<String> Register_Otp(@RequestBody Account entity) {
		String email = entity.getEmail();
		if (AS.Save_Register_Otp(email))
			return new ResponseEntity<String>("OTP sent successfully validate", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Account details already exists", HttpStatus.UNAUTHORIZED);

	}

	@PostMapping("/create_profile")
	public ResponseEntity<String> Account_Create(@RequestBody Account account) {

		if (AS.Save_Account(account))
			new ResponseEntity<>("Account succesfully created", HttpStatus.OK);
		return new ResponseEntity<>("Invalid otp please re enter your otp", HttpStatus.UNAUTHORIZED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> Login_Validate(@RequestBody LoginOtp entity) {
		if (AS.Login(entity.getEmail(), entity.getPassword())) {
			System.out.println("succesfully login");
			return new ResponseEntity<>("Succesfully login", HttpStatus.OK);
		}
		return new ResponseEntity<>("Invalid otp details", HttpStatus.UNAUTHORIZED);
	}

	@PostMapping("/forgot_password")
	public ResponseEntity<String> Forgot_Password(@RequestBody LoginOtp entity) {
		if (AS.Upadate_Password_Otp(entity.getEmail())) {
			return new ResponseEntity<String>("otp sent validate it", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Your account doesnot exists please enter correct email",
				HttpStatus.UNAUTHORIZED);
	}

	@PostMapping("/reset_password")
	public ResponseEntity<String> Reset_Password(@RequestBody LoginOtp entity) {

		String email = entity.getEmail();
		String otp = entity.getOtp();
		String password = entity.getPassword();
		if (AS.Validate_Update_Password_OTP(email, otp, password)) {
			return new ResponseEntity<String>("Successfully updated your password", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Invalid otp", HttpStatus.UNAUTHORIZED);
	}

}
