package com.java.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.Model.SubjectWiseNotes;
import com.java.Repository.NotesRepository;

@Service
public class NotesService {

	@Autowired
	private NotesRepository repo;

	public void SaveNotes(SubjectWiseNotes notes) {
		repo.save(notes);
	}

	public List<SubjectWiseNotes> getAllNotes() {
		return repo.findAll();
	}

	public List<SubjectWiseNotes> getNotesByEmail(String email) {
		List<SubjectWiseNotes> allNotes = getAllNotes();
		List<SubjectWiseNotes> notes = new ArrayList<>();
		for (SubjectWiseNotes list : allNotes) {
			if (list.getEmail().equals(email))
				notes.add(list);
		}
		return notes;
	}

	public SubjectWiseNotes getNotesById(Long id) {
		return repo.findById(id).get();
	}

	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	public void deleteAllNotesByEmail(String email) {
		List<SubjectWiseNotes> allNotes = getAllNotes();
		for (SubjectWiseNotes list : allNotes) {
			if (list.getEmail().endsWith(email))
				repo.deleteById(list.getId());
		}
	}
}
