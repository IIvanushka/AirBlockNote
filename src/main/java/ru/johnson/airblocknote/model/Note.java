package ru.johnson.airblocknote.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "notes")
public class Note extends BaseEntity{

    @Column(name = "user_id")
    private Integer iduser;

    @Column(name = "active")
    private boolean active;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "note")
    private List<NoteEntity> noteEntities;

    public Note() {
    }

    public Note(Integer iduser, boolean active) {
        this.iduser = iduser;
        this.active = active;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<NoteEntity> getNoteEntities() {
        return noteEntities;
    }

    public void setNoteEntities(List<NoteEntity> noteEntities) {
        this.noteEntities = noteEntities;
    }

    public void addNoteEntity(NoteEntity noteEntity) {
        noteEntities.add(noteEntity);
    }

    @Override
    public String toString() {
        return "Note{" +
                "iduser=" + iduser +
                ", active=" + active +
                ", description='" + description + '\'' +
                ", noteEntities=" + noteEntities +
                '}';
    }
}
