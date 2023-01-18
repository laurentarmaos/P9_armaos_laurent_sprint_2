package com.mediscreen.services;

import java.util.List;

import org.springframework.stereotype.Service;

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
	public Note addNote(Note dto) {

		Note entity = new Note();
		
		entity.setPractitionnerNote(dto.getPractitionnerNote());
		entity.setPatientId(dto.getPatientId());

		noteRepository.save(entity);
		
		return entity;
	}
	
}
