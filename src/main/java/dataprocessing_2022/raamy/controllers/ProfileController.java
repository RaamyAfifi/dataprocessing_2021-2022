package dataprocessing_2022.raamy.controllers;

import dataprocessing_2022.raamy.models.ProfileModel;
import dataprocessing_2022.raamy.repositories.ProfileRepository;
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
@RequestMapping("/profiles")
public class ProfileController
{
    @Autowired
    private ProfileRepository service;

    @CrossOrigin
    @GetMapping
    public Iterable<ProfileModel> findAllProfile() {
        return service.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
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
