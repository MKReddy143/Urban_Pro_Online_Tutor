package com.java.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.Model.Account;
import com.java.OptionalClasses.EmailService;
import com.java.Repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repo;

	private EmailService emailService;

	public AccountService(EmailService emailService) {
		super();
		this.emailService = emailService;
	}

	public List<Account> GetAllAccounts() {
		return repo.findAll();
	}

	public List<Account> getTutorsAccountList() {
		List<Account> tutors = new ArrayList<>();
		List<Account> getAllAccounts = GetAllAccounts();
		for (Account list : getAllAccounts) {
			if (list.getRole().equals("tutor"))
				tutors.add(list);
		}
		return tutors;
	}

	public Account getAccount(String email) {
		Account ac = repo.findById(email).orElse(null);
		return ac;
	}

	public boolean Save_Account(Account account) {
		if (null != getAccount(account.getEmail())) {
			if (Validate_Regiter_Otp(account.getEmail(), account.getOtp())) {
				account.setOtp(null);
				account.setValidate(true);
				repo.save(account);
				return true;
			}
		}
		return false;
	}

	public boolean Validate_Regiter_Otp(String email, String otp) {
		Account account = getAccount(email);
		if (otp.equals(account.getOtp())) {
			account.setOtp(null);
			repo.save(account);
			return true;
		}
		return false;
	}

	public boolean Validate_Update_Password_OTP(String email, String otp, String password) {
		Account account = getAccount(email);
		if (otp.equals(account.getOtp())) {
			account.setOtp(null);
			account.setPassword(password);
			repo.save(account);
			return true;
		}
		return false;
	}

	public boolean Login(String email, String password) {
		Account account = getAccount(email);
		if (account != null) {
			if ((account.getPassword().equals(password))) {
				account.setOtp(null);
				repo.save(account);
				return true;
			}
		}
		return false;
	}

	public boolean Save_Register_Otp(String email) {
		Account ac = getAccount(email);
		Account account = new Account();
		if (ac == null) {
			account.setEmail(email);
			account.setValidate(false);
			String otp = generateOTP();
			account.setOtp(otp);
			System.out.println(otp);
			emailService.sendEmail(email, otp);
			repo.save(account);
			return true;
		}
		return false;
	}

	public boolean Upadate_Password_Otp(String email) {
		Account account = getAccount(email);
		if (account != null) {
			String otp = generateOTP();
			account.setOtp(otp);
			// send otp to respected registered email
			System.out.println(otp);
			emailService.sendEmail(email, otp);
			repo.save(account);
			return true;
		}
		return false;
	}

	public void UpdatePassword(String email, String Password) {
		Account account = repo.findById(email).get();
		account.setPassword(Password);
		repo.save(account);
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
