package com.java.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.Model.BookClass;
import com.java.Services.BookClassServices;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/class")
public class BookClassController {

	private BookClassServices service;

	public BookClassController(BookClassServices service) {
		super();
		this.service = service;
	}

	@PostMapping("/book")
	public ResponseEntity<String> saveClass(@RequestBody BookClass entity) {
		service.bookclass(entity);
		return ResponseEntity.ok("success");
	}

	@GetMapping("/get_student/{email}")
	public ResponseEntity<List<BookClass>> getStudentClass(@PathVariable String email) {

		return ResponseEntity.ok(service.GetStudentClass(email));
	}

	@GetMapping("/get_tutor/{email}")
	public ResponseEntity<List<BookClass>> getTutorClass(@PathVariable String email) {

		return ResponseEntity.ok(service.GetTutorsClass(email));
	}

	@GetMapping("/get_id/{id}")
	public ResponseEntity<BookClass> getIdClass(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteClass(@PathVariable Long id) {
		service.DeleteClass(id);
		return ResponseEntity.ok("success");
	}

	@PutMapping("update/{id}/{amount}")
	public ResponseEntity<BookClass> UpdateBalance(@PathVariable Long id, @PathVariable int amount) {
		service.UpdateBalance(id, amount);
		return ResponseEntity.ok(service.getById(id));
	}

}
