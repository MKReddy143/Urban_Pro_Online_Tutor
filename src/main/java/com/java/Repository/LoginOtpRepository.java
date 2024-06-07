package com.java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.Model.LoginOtp;

@Repository
public interface LoginOtpRepository extends JpaRepository<LoginOtp, String> {

}
