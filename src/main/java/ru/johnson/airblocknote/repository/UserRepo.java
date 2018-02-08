package ru.johnson.airblocknote.repository;

import org.springframework.data.repository.CrudRepository;
import ru.johnson.airblocknote.model.User;

public interface UserRepo extends CrudRepository<User, Long> {
}
