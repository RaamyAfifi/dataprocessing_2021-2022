package dataprocessing_2022.raamy.controllers;

import dataprocessing_2022.raamy.models.AnimeModel;
import dataprocessing_2022.raamy.repositories.AnimeRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/animes", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class AnimeController
{
    @Autowired
    private AnimeRepository service;

    @CrossOrigin
    @GetMapping
    @ApiOperation(
            value = "Find all animes",
            notes = "This is to select all animes. If you would like to select a specific anime use following: http://localhost:8080/reviews/{id}",
            response = List.class )

    public Iterable<AnimeModel> findAllAnime() {
        return service.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @ApiOperation(
            value = "",
            notes = "",
            response = AnimeModel.class )
    public ResponseEntity<AnimeModel> findAnimeById(@ApiParam(value = "") @PathVariable(value = "id") int id) {
        Optional<AnimeModel> anime = service.findById(id);

        return anime.map(animeModel -> ResponseEntity.ok().body(animeModel)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ApiOperation(
            value = "",
            notes = "",
            response = AnimeModel.class )
    @ResponseStatus(HttpStatus.CREATED)
    public AnimeModel create(@Valid @RequestBody AnimeModel animeModel) {
        return service.save(animeModel);
    }

    @PutMapping("/{id}")
    @ApiOperation(
            value = "Puts an anime into the database",
            notes = "",
            response = AnimeModel.class )
    public AnimeModel replaceEmployee(@ApiParam(value = "Id of the anime you would like to update") @RequestBody AnimeModel animeModel, @PathVariable int id) {
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
    @ApiOperation(
            value = "Deletes a specific anime by ID",
            notes = "" )
    void deleteEmployee(@ApiParam(value = "Id of the anime you would like to delete.") @PathVariable int id) {
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
