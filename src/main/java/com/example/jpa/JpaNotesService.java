package com.example.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Notes;
import com.example.service.NotesService;

@Repository
@Transactional(readOnly = true)
public class JpaNotesService implements NotesService {
		@PersistenceContext
	    private EntityManager entityManager;

		@Override
		public Notes updateNotes(long id, String subject, String body) {
			Notes note = this.getNotesById(id);
			note.setBody(body);
	        note.setSubject(subject);
	        this.entityManager.merge(note);
	        return getNotesById(id);
		}

		@Transactional(readOnly = true)
		public Notes getNotesById(long id) {
			 return this.entityManager.find(Notes.class, id);
		}

		@Override
		public Collection<Notes> getAllNotes() {
			CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
	        CriteriaQuery<Notes> criteriaBuilderQuery = criteriaBuilder.createQuery(Notes.class);
	        CriteriaQuery<Notes> customerCriteriaQuery = criteriaBuilderQuery.select(
	                criteriaBuilderQuery.from(Notes.class));
	        return this.entityManager.createQuery(customerCriteriaQuery).getResultList();
		}

		@Override
		public Notes createNote(String subject, String body) {
			Notes newNote = new Notes();
			newNote.setSubject(subject);
			newNote.setBody(body);
		    this.entityManager.persist(newNote);
		    return newNote;
		}

		@Transactional
		public void deleteNote(long id) {
			Notes noteToDelete = this.entityManager.find(Notes.class, id);
			this.entityManager.remove(noteToDelete);
		}

		@Override
		public Notes createNote(Notes newNote) {
			 this.entityManager.persist(newNote);
		     return newNote;
		}

		@Override
		public Notes updateNotes(long id, Notes updateNote) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Notes> bulkCreate(List<Notes> notes) {
			// TODO Auto-generated method stub
			return null;
		}
}
