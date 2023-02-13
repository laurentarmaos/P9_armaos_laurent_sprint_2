package com.mediscreen.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.mediscreen.entities.Note;
import com.mediscreen.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService{
	
	NoteRepository noteRepository;
	
	public NoteServiceImpl(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	@Override
	public List<Note> findAllNotes() {
		
		return noteRepository.findAll();
	}
	
	
	@Override
	public List<Note> findNoteByPatientId(String patientId) {

		return noteRepository.findAllByPatientId(patientId);
	}
	
	@Override
	public Note addNote(String practitionnerNotes, String patientId) {

		Note entity = new Note();
		
		entity.setPractitionnerNotes(practitionnerNotes);
		entity.setPatientId(patientId);

		noteRepository.save(entity);
		
		return entity;
	}

	@Override
	public Note updateNote(Note note) {
		
		noteRepository.save(note);
		
		return note;
	}

	@Override
	public void deleteNote(String noteId) {
		
		noteRepository.deleteById(noteId);
	}

	@Override
	public Note findNote(String noteId) {

		return noteRepository.findById(noteId).get();
	}
	
	
	
}
