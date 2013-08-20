package com.example.service;

import java.util.Collection;
import java.util.List;

import com.example.model.Notes;

public interface NotesService {
	    Notes updateNotes(long id, String subject, String body);
	    Notes getNotesById(long id);
	    Collection<Notes> getAllNotes();
	    Notes createNote(String subject, String body);
	    void deleteNote(long id);
	    Notes createNote(Notes newNote);
	    Notes updateNotes(long id, Notes updateNote);
	    List<Notes> bulkCreate(List<Notes> notes);
}
