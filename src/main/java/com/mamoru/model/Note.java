package com.mamoru.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * user: alekseyb
 * date: 4/19/17
 */
@Entity
public class Note {


    private Long id;

    private String text;

    private Set<Tag> tags;

    public Note() {
    }

    public Note(String text,  Set<Tag> tags) {
        this.text = text;
        this.tags = tags;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "note_tag", joinColumns = @JoinColumn(name = "note_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        String result = String.format(
                "Note [id=%d, name='%s']%n",
                id, text);
        if (tags != null) {
            for(Tag tag : tags) {
                result += String.format(
                        "Tag[id=%d, name='%s']%n",
                        tag.getId(), tag.getName());
            }
        }

        return result;
    }

}
