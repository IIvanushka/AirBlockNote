package ru.johnson.airblocknote.repository;

import org.springframework.data.repository.CrudRepository;
import ru.johnson.airblocknote.model.NoteEntity;

public interface EntityRepo extends CrudRepository<NoteEntity, Integer> {
}
