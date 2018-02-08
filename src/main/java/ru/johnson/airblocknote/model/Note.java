package ru.johnson.airblocknote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "note")
public class Note extends BaseEntity{

    @Column(name = "iduser")
    private Long iduser;

    @Column(name = "active")
    private boolean active;

    public Note() {
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
