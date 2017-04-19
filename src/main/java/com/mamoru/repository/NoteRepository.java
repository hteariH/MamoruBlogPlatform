package com.mamoru.repository;

import com.mamoru.model.Note;
import org.springframework.data.repository.CrudRepository;

/**
 * user: alekseyb
 * date: 4/19/17
 */
public interface NoteRepository extends CrudRepository<Note, Long> {
}
