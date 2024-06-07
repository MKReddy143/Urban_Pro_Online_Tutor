package com.java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.Model.SubjectWiseNotes;

@Repository
public interface NotesRepository extends JpaRepository<SubjectWiseNotes, Long> {

}
