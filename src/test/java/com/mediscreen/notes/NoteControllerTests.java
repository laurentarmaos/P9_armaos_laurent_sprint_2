package com.mediscreen.notes;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	@Test
	public void findNoteTest() throws Exception {
		Note note = new Note();
		note.setId("1");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/note/{noteId}", note.getId())).andExpect(status().isOk());
	}
	
	@Test
	public void updateNoteTest() throws Exception {
		Note note = new Note();
		note.setId("1");
		
		mockMvc.perform(MockMvcRequestBuilders.put("/note/update")
				.contentType(MediaType.APPLICATION_JSON)
		        .content(asJsonString(note)))
		.andExpect(status().isOk());
	}
	
	@Test
	public void findNoteByPatientIdTest() throws Exception{
		Note note = new Note();
		note.setPatientId("1");
		
		mockMvc.perform(MockMvcRequestBuilders.get(
				"/patient/{patientId}/findnotes",
				note.getPatientId()
			)).andExpect(status().isOk());
	}

	@Test
	public void addNoteTest() throws Exception {
		Note note = new Note();
		note.setPatientId("1");
		note.setPractitionnerNotes("note");
		
		mockMvc.perform(MockMvcRequestBuilders.post(
					"/patient/addnote",
					note.getPractitionnerNotes(),
					note.getPatientId()
				)).andExpect(status().isOk());
	}
	
	@Test
	public void deleteNoteTest() throws Exception {
		Note note = new Note();
		note.setId("1");
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/note/{noteId}/delete", note.getId())).andExpect(status().isOk());
	}

}
