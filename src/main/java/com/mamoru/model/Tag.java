package com.mamoru.model;

import javax.persistence.*;
import java.util.Set;

/**
 * user: alekseyb
 * date: 4/19/17
 */
@Entity
public class Tag {

    private Long id;

    private String name;

    private Set<Note> notes;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "tags")
    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }
}
