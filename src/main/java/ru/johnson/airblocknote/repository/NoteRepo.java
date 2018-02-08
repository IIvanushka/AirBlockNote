package ru.johnson.airblocknote.repository;

import org.springframework.data.repository.CrudRepository;
import ru.johnson.airblocknote.model.Note;

public interface NoteRepo extends CrudRepository<Note, Long> {
}
