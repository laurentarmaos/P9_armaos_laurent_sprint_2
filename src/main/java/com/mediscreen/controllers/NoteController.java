package com.mediscreen.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		
	
	@GetMapping("/patient/{patientId}/findnotes")
	public List<Note> findNoteByPatientId(@PathVariable String patientId) {
		
		//System.out.println(noteService.findNoteByPatientId(patientId).get(0).getPractitionnerNote());
		return noteService.findNoteByPatientId(patientId);
	}
	
	@PostMapping("/patient/addnote")
	public Note addNote(@RequestParam(value="practitionnerNotes", required = false) String practitionnerNotes, @RequestParam(value="patientId", required = false) String patientId) {
		return noteService.addNote(practitionnerNotes, patientId);
	}

}
