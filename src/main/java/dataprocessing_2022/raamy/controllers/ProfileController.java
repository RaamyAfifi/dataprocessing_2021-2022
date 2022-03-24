package dataprocessing_2022.raamy.controllers;

import dataprocessing_2022.raamy.models.ProfileModel;
import dataprocessing_2022.raamy.repositories.ProfileRepository;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value = "/profiles", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class ProfileController
{
    @Autowired
    private ProfileRepository service;

    @CrossOrigin
    @GetMapping
    @ApiOperation(
            value = "Get all profiles from the database",
            notes = "",
            response = List.class )
    public Iterable<ProfileModel> findAllProfile() {
        return service.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @ApiOperation(
            value = "Finds a profile by the id, which is a string.",
            notes = "",
            response = ProfileModel.class )
    public ResponseEntity<ProfileModel> findProfileById(@PathVariable(value = "id") String id) {
        Optional<ProfileModel> profile = service.findById(id);

        return profile.map(profileModel -> ResponseEntity.ok().body(profileModel)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileModel create(@Valid @RequestBody ProfileModel profileModel) {
        return service.save(profileModel);
    }

    @PutMapping("/{id}")
    @ApiOperation(
            value = "Puts a profile into the database",
            notes = "",
            response = ProfileModel.class )
    public ProfileModel replaceEmployee(@RequestBody ProfileModel profileModel, @PathVariable String id) {
        return service.findById(id)
                .map(profile -> {
                    profile.setProfile(profileModel.getProfile());
                    profile.setGender(profileModel.getGender());
                    profile.setBirthday(profileModel.getBirthday());
                    profile.setFavorites_anime(profileModel.getFavorites_anime());
                    profile.setLink(profileModel.getLink());

                    return service.save(profile);
                })
                .orElseGet(() -> {
                    profileModel.setProfile(id);
                    return service.save(profileModel);
                });
    }

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Deletes a specific profile by id. If you would like to delete a specific profile use following: http://localhost:8080/profiles/{id}",
            notes = "",
            response = ProfileModel.class )
    void deleteEmployee(@PathVariable String id) {
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
