package ru.johnson.airblocknote.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.johnson.airblocknote.model.Note;
import ru.johnson.airblocknote.repository.EntityRepo;
import ru.johnson.airblocknote.repository.NoteRepo;

import javax.persistence.JoinColumn;
import java.util.List;

@Service
public class AppService {

    @Autowired
    private NoteRepo noteRepo;

    @Autowired
    private EntityRepo entityRepo;

    public List<Note> getAllNotes() {
        return (List<Note>) noteRepo.findAll();
    }

    public Note greateOrUpdate (Note note) {
        Note note1 = noteRepo.save(note);
        entityRepo.save(note.getNoteEntities());
        return note1;
    }
}
