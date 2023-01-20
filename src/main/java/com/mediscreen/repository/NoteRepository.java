package com.mediscreen.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mediscreen.entities.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String>{

	//List<Note> findByPatient_id(String id);
}
