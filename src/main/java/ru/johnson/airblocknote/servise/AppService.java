package ru.johnson.airblocknote.servise;

import org.springframework.beans.factory.annotation.Autowired;
import ru.johnson.airblocknote.model.Note;
import ru.johnson.airblocknote.repository.NoteRepo;

import java.util.List;

public class AppService {

    @Autowired
    private NoteRepo noteRepo;

    public List<Note> getAll() {
        return (List<Note>) noteRepo.findAll();
    }
}
