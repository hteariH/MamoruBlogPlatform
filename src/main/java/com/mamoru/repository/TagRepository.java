package com.mamoru.repository;

import com.mamoru.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * user: alekseyb
 * date: 4/19/17
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
}
