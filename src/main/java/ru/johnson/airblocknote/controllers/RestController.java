package ru.johnson.airblocknote.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.johnson.airblocknote.model.User;
import ru.johnson.airblocknote.servise.UserService;

import javax.validation.Valid;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = RestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestController {
    static final String REST_URL = "/rest/";

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User createOrUpdate(@Valid User user) {
        return userService.createOrUpdate(user);
    }
}
