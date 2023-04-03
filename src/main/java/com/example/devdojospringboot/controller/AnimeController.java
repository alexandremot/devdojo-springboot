package com.example.devdojospringboot.controller;

import com.example.devdojospringboot.domain.Anime;
import com.example.devdojospringboot.requests.AnimePostRequestBody;
import com.example.devdojospringboot.requests.AnimePutRequestBody;
import com.example.devdojospringboot.service.AnimeService;
import com.example.devdojospringboot.utils.Dateutil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("animes")
public class AnimeController {

    private final Dateutil dateutil;
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> list() {
        log.info(dateutil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id) {
        log.info(dateutil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(animeService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody AnimePostRequestBody anime){
        return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnimePutRequestBody animePutRequestBody){
        animeService.replace(animePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
