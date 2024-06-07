package com.java.Services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.Model.LoginOtp;
import com.java.Repository.LoginOtpRepository;

@Service
public class Otp_Service {

	@Autowired
	private LoginOtpRepository repo;

	public void GenerateLoginOtp(String email) {
		LoginOtp otp = new LoginOtp();
		Otp_Service service = new Otp_Service();
		String otp2 = service.generateOTP();
		otp.setOtp(otp2);
		// Here send One Time Password to email
		System.out.println(otp2);
		otp.setEmail(email);
		otp.setValidate(false);
	}
	public void SavePassword(LoginOtp otp) {
		repo.save(otp);
	}

	public boolean Validate_Register_Otp(String email, String otp) {
		LoginOtp byId = repo.findById(email).get();
		if (byId.getOtp().equals(otp)) {
			repo.deleteById(email);
			return true;
		}
		return false;
	}

	public boolean resetPassword(LoginOtp login) {
		LoginOtp otp = repo.findById(login.getEmail()).get();
		if (otp.getOtp().equals(login.getOtp())) {
			otp.setPassword(login.getPassword());
			otp.setOtp(null);
			otp.setValidate(true);
			repo.save(otp);
			return true;
		}
		return false;
	}

	public String generateOTP() {
		String numbers = "0123456789";
		Random rndm_method = new Random();
		char[] otp = new char[6];
		for (int i = 0; i < 6; i++) {
			otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return new String(otp);
	}
}
