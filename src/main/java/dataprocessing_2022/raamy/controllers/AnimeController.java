package dataprocessing_2022.raamy.controllers;

import dataprocessing_2022.raamy.exceptions.ResourceNotFoundException;
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
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController
@RequestMapping(value = "/animes", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = MediaType.ALL_VALUE)
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
            value = "Gets a specific anime by id. If you would like to select a specific anime use following: http://localhost:8080/animes/{id}",
            notes = "id is a number starting from 1",
            response = AnimeModel.class )
    public ResponseEntity<AnimeModel> findAnimeById(@ApiParam(value = "") @PathVariable(value = "id") int id) throws ResourceNotFoundException
    {
        Optional<AnimeModel> anime = service.findById(id);

        return anime.map(animeModel -> ResponseEntity.ok().body(animeModel)).orElseThrow(() -> new ResourceNotFoundException("There is no Anime with uid" + id));
    }

    @PostMapping
    @ApiOperation(
            value = "Creates",
            notes = "",
            response = AnimeModel.class )
    @ResponseStatus(HttpStatus.CREATED)
    public AnimeModel createAnime(@Valid @RequestBody AnimeModel animeModel) {
        return service.save(animeModel);
    }


    @PutMapping("/{id}")
    @ApiOperation(
            value = "Update/puts an anime into the database",
            notes = "",
            response = AnimeModel.class )
    public AnimeModel replaceAnime(@ApiParam(value = "Id of the anime you would like to update") @RequestBody AnimeModel animeModel, @PathVariable int id) throws ResourceNotFoundException
    {
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
                .orElseThrow(() -> new ResourceNotFoundException("There is no Anime with uid" + id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Deletes a specific anime by ID",
            notes = "" )
    public Map<String, Boolean> deleteAnime(@ApiParam(value = "Id of the anime you would like to delete.") @PathVariable int id) throws ResourceNotFoundException
    {
        AnimeModel animeModel = service.findById(id).orElseThrow(() -> new ResourceNotFoundException("There is no Anime with uid" + id));
        service.delete(animeModel);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", true);
        return  response;
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

