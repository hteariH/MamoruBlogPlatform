package com.mamoru.repository;

import com.mamoru.model.Tag;
import org.springframework.data.repository.CrudRepository;

/**
 * user: alekseyb
 * date: 4/19/17
 */
public interface TagRepository extends CrudRepository<Tag, Long> {
}
