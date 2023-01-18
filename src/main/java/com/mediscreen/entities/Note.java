package com.mediscreen.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="notes")
public class Note {

	@Id
	private String id;
	
	private String practitionner_notes;

	private String patient_id;
	
	public Note() {}

	
	public String getNote() {
		return practitionner_notes;
	}

	public void setNote(String practitionner_notes) {
		this.practitionner_notes = practitionner_notes;
	}
	

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}


	public String getId() {
		return id;
	}
	
	
}
