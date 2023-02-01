package com.mediscreen.services;

import java.util.List;

import com.mediscreen.entities.Note;

public interface NoteService {

	List<Note> findAllNotes();
	
	List<Note> findNoteByPatientId(String patientId);

	Note addNote(String practitionnerNotes, String patientId);
}
