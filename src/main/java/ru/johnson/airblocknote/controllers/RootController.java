package ru.johnson.airblocknote.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RootController {

    private static Map<String, Object> model = new HashMap<>();
    private static List<String> visited = new ArrayList<>();

    @GetMapping("/")
    public ModelAndView index() {
        visited.add(LocalDateTime.now().toString().replaceAll("T", " "));

        model.put("date", visited);

        return new ModelAndView("index", model);
    }
}
