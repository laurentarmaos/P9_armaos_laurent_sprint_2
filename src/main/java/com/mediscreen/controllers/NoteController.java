package com.mediscreen.controllers;

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
		
	@PostMapping("/patient/addnote")
	public Note addNote(@RequestBody Note note) {
		return noteService.addNote(note);
	}

}
