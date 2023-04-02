package com.example.devdojospringboot.controller;

import com.example.devdojospringboot.domain.Anime;
import com.example.devdojospringboot.utils.Dateutil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

    private final Dateutil dateutil;

    @GetMapping("/list")
    public List<Anime> list() {
        log.info(dateutil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return List.of(new Anime("Attack on Titan"), new  Anime("Naruto"));
    }
}