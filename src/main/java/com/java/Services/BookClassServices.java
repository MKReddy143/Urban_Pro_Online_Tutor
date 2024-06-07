package com.java.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.Model.BookClass;
import com.java.Repository.BookClassRepository;

@Service
public class BookClassServices {

	@Autowired
	private BookClassRepository repo;

	public void bookclass(BookClass cls) {
		repo.save(cls);
	}

	public List<BookClass> getAll() {
		return repo.findAll();
	}

	public BookClass getById(Long id) {
		return repo.findById(id).get();
	}

	public List<BookClass> GetStudentClass(String email) {
		List<BookClass> list = getAll();
		List<BookClass> listBymail = new ArrayList<>();
		for (BookClass all : list) {
			if (all.getStudent_email().equals(email))
				listBymail.add(all);
		}
		return listBymail;
	}

	public List<BookClass> GetTutorsClass(String email) {
		List<BookClass> list = getAll();
		List<BookClass> listBymail = new ArrayList<>();
		for (BookClass all : list) {
			if (all.getTutor_email().equals(email))
				listBymail.add(all);
		}
		return listBymail;
	}

	public void DeleteClass(Long id) {
		repo.deleteById(id);
	}

	public void UpdateBalance(Long id, int amount) {
		BookClass class1 = repo.findById(id).get();
		int fee = class1.getBalanceFee();
		fee = fee - amount;
		class1.setBalanceFee(fee);
		repo.save(class1);
	}
}
