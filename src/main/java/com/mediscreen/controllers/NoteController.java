package com.mediscreen.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediscreen.entities.Note;
import com.mediscreen.services.NoteService;

@RestController
public class NoteController {
	
	private final NoteService noteService;
	
	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@GetMapping("/note/{noteId}")
	public Note findNote(@PathVariable String noteId) {
		return noteService.findNote(noteId);
	}
	
	
	@GetMapping("/patient/{patientId}/findnotes")
	public List<Note> findNoteByPatientId(@PathVariable String patientId) {

		return noteService.findNoteByPatientId(patientId);
	}
	
	@PostMapping("/patient/addnote")
	public Note addNote(@RequestParam(value="practitionnerNotes", required = false) String practitionnerNotes, @RequestParam(value="patientId", required = false) String patientId) {
		return noteService.addNote(practitionnerNotes, patientId);
	}
	
	@PutMapping("/note/update")
	public Note updateNote(@RequestBody Note note) {
		
		return noteService.updateNote(note);
	}
	
	@DeleteMapping("/note/{noteId}/delete")
	public void deleteNote(@PathVariable("noteId") String noteId) {
		noteService.deleteNote(noteId);
	}

}
