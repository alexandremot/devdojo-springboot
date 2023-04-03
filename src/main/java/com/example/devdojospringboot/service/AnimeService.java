package com.example.devdojospringboot.service;

import com.example.devdojospringboot.domain.Anime;
import com.example.devdojospringboot.repository.AnimeRepository;
import com.example.devdojospringboot.requests.AnimePostRequestBody;
import com.example.devdojospringboot.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;
    public List<Anime> listAll(){
        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequestException(long id){
        return animeRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found!"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
        Anime anime = Anime.builder().name(animePostRequestBody.getName()).build();
        return animeRepository.save(anime);
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = Anime.builder()
                            .id(savedAnime.getId())
                            .name(animePutRequestBody.getName())
                            .build();
        animeRepository.save(anime);
    }
}
