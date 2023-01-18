package com.mediscreen.services;

import java.util.List;

import com.mediscreen.entities.Note;

public interface NoteService {

	List<Note> findAllNotes();
	
	Note addNote(Note note);

}
