package ru.johnson.airblocknote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "noteentities")
public class NoteEntity extends BaseEntity {

    @Column(name = "noteid", nullable = false)
    @NotNull
    private Long noteId;

    @Column(name = "article")
    private String article;

    public NoteEntity() {
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
