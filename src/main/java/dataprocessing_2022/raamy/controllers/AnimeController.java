package dataprocessing_2022.raamy.controllers;

import dataprocessing_2022.raamy.models.AnimeModel;
import dataprocessing_2022.raamy.repositories.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/animes")
public class AnimeController
{
    @Autowired
    private AnimeRepository service;

    @CrossOrigin
    @GetMapping
    public Iterable<AnimeModel> findAllAnime() {
        return service.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<AnimeModel> findAnimeById(@PathVariable(value = "id") int id) {
        Optional<AnimeModel> anime = service.findById(id);

        return anime.map(animeModel -> ResponseEntity.ok().body(animeModel)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimeModel create(@Valid @RequestBody AnimeModel animeModel) {
        return service.save(animeModel);
    }

    @PutMapping("/{id}")
    public AnimeModel replaceEmployee(@RequestBody AnimeModel animeModel, @PathVariable int id) {
        return service.findById(id)
                .map(anime -> {
                    anime.setUid(animeModel.getUid());
                    anime.setTitle(animeModel.getTitle());
                    anime.setGenre(animeModel.getGenre());
                    anime.setAired(animeModel.getAired());
                    anime.setEpisodes(animeModel.getEpisodes());
                    anime.setMembers(animeModel.getMembers());
                    anime.setScore(animeModel.getScore());

                    return service.save(anime);
                })
                .orElseGet(() -> {
                    animeModel.setUid(id);
                    return service.save(animeModel);
                });
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable int id) {
        service.deleteById(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
