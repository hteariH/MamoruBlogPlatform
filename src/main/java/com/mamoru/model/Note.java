package com.mamoru.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * user: alekseyb
 * date: 4/19/17
 */
@Entity
public class Note {


    private Long id;

    private String title;

    @Lob
    private String shortText;

    @Lob
    private String text;

    private String img = null;

    private Date date;

    private Set<Tag> tags;

    public Note() {
    }

    public Note(String title, String img, String text, Set<Tag> tags) {
        this.title = title;
        this.img = img;
        this.shortText=text.substring(0,text.indexOf('\n'));
        this.text = text;
        this.tags = tags;
        date = new Date(System.currentTimeMillis());
    }

    public Note(String title, String shortText, String img, String text, Set<Tag> tags) {
        this.title = title;
        this.shortText = shortText;
        this.text = text;
        this.tags = tags;
        date = new Date(System.currentTimeMillis());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
