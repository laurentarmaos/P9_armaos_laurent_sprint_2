package com.mediscreen.notes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestParam;

import com.mediscreen.controllers.NoteController;
import com.mediscreen.entities.Note;
import com.mediscreen.services.NoteService;

@SpringBootTest
public class NoteControllerTests {
	
	@MockBean
	private NoteService noteService;
	
	private NoteController noteController;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		noteController = new NoteController(noteService);
		mockMvc = MockMvcBuilders.standaloneSetup(noteController).build();
	}
	

//TODO corriger le pb dû au @RequestParam
	@Test
	public void addNoteTest() throws Exception {
		Note note = new Note();
		note.setPatientId("1");
		note.setPractitionnerNote("note");
		
		when(noteService.addNote(note.getPractitionnerNote(), note.getPatientId())).thenReturn(note);
		
		Note savedNote = noteController.addNote(note.getPractitionnerNote(), note.getPatientId());
		
		
		assertNotNull(savedNote);
		assertEquals(savedNote, note);
		
		
//		mockMvc.perform(MockMvcRequestBuilders.post(
//					"/patient/addnote",
//					note.getPractitionnerNote(),
//					note.getPatientId()
//				)).andExpect(status().isOk());
	}

}
