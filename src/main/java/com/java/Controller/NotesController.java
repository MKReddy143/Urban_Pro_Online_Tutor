package com.java.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.Model.SubjectWiseNotes;
import com.java.Services.NotesService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/notes")
public class NotesController {

	private NotesService service;

	public NotesController(NotesService service) {
		super();
		this.service = service;
	}

	@PostMapping("/add_notes")
	public ResponseEntity<String> Add_Notes(@RequestBody SubjectWiseNotes notes) {
		service.SaveNotes(notes);
		return ResponseEntity.ok("successfully added");
	}

	@GetMapping("/by_id/{id}")
	public ResponseEntity<SubjectWiseNotes> Notes_By_Id(@PathVariable Long id) {
		return new ResponseEntity<SubjectWiseNotes>(service.getNotesById(id), HttpStatus.OK);
	}

	@GetMapping("/by_email/{email}")
	public ResponseEntity<List<SubjectWiseNotes>> getMethodName(@PathVariable String email) {
		return ResponseEntity.ok(service.getNotesByEmail(email));
	}

	@DeleteMapping("/delete_by_id/{id}")
	public ResponseEntity<String> deletebyid(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.ok("succesfully deleted");
	}

	@DeleteMapping("/delete_by_email/{email}")
	public ResponseEntity<String> deleteByEmial(@PathVariable String email) {
		service.deleteAllNotesByEmail(email);
		return new ResponseEntity<String>("successfully deleted", HttpStatus.OK);
	}

}
