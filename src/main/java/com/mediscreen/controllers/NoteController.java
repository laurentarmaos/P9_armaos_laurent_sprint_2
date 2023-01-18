package com.mediscreen.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mediscreen.entities.Note;
import com.mediscreen.services.NoteService;

@RestController
public class NoteController {
	
	private final NoteService noteService;
	
	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@PostMapping("/patient/addnote/{id}")
	public Note addNote(@RequestBody Note note, @PathVariable("id") String id) {
		note.setPatient_id(id);
		return noteService.addNote(note);
	}
}
