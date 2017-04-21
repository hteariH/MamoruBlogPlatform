package com.mamoru.repository;

import com.mamoru.model.Note;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * user: alekseyb
 * date: 4/19/17
 */
@Cacheable
public interface NoteRepository extends JpaRepository<Note, Long> {
}
