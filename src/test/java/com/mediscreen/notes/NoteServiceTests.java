package com.mediscreen.notes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mediscreen.entities.Note;
import com.mediscreen.repository.NoteRepository;
import com.mediscreen.services.NoteService;
import com.mediscreen.services.NoteServiceImpl;

@SpringBootTest
public class NoteServiceTests {
	
	@MockBean
	private NoteRepository noteRepository;
	
	private NoteService noteService;
	
	@BeforeEach
	public void setUp() {
		noteService = new NoteServiceImpl(noteRepository);
	}
	
	@Test
	public void addNoteTest() {
		Note note = new Note();
		note.setPatientId("1");
		note.setPractitionnerNotes("note");
		
		when(noteRepository.save(Mockito.any(Note.class))).thenReturn(note);
		
		Note savedNote = noteService.addNote(note.getPractitionnerNotes(), note.getPatientId());
		
		assertNotNull(savedNote);
		assertEquals(note.getPatientId(), savedNote.getPatientId());
		assertEquals(note.getPractitionnerNotes(), savedNote.getPractitionnerNotes());
		verify(noteRepository).save(Mockito.any(Note.class));
	}
	
	@Test
	public void findNoteByPatientIdTest() {
		Note note1 = new Note();
		note1.setPatientId("1");
		
		Note note2 = new Note();
		note2.setPatientId("1");
		
		List<Note> allNotes = new ArrayList<>();
		allNotes.add(note1);
		allNotes.add(note2);
		
		when(noteRepository.findAllByPatientId("1")).thenReturn(allNotes);
		
		List<Note> savedNotes = noteService.findNoteByPatientId("1");
		
		assertEquals(savedNotes.size(), 2);
		assertEquals(savedNotes.get(0), note1);
		verify(noteRepository).findAllByPatientId(Mockito.anyString());
	}
	
	@Test
	public void findAllNotesTest() {
		Note note1 = new Note();
		note1.setPatientId("1");
		note1.setPractitionnerNotes("note");
		
		Note note2 = new Note();
		note2.setPatientId("1");
		note2.setPractitionnerNotes("note2");
		
		List<Note> allNotes = new ArrayList<>();
		allNotes.add(note1);
		allNotes.add(note2);
		
		when(noteRepository.findAll()).thenReturn(allNotes);
		
		List<Note> allSavedNotes = noteService.findAllNotes();
		
		assertEquals(allSavedNotes.size(), 2);
		assertEquals(allSavedNotes.get(0), note1);
	}
	
	
	@Test
	public void deleteNote() {
		noteService.deleteNote("1");
		
		verify(noteRepository).deleteById(Mockito.anyString());
	}
	

}
