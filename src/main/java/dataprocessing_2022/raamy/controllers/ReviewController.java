package dataprocessing_2022.raamy.controllers;

import dataprocessing_2022.raamy.models.ReviewModel;
import dataprocessing_2022.raamy.repositories.ReviewRepository;
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
@RequestMapping("/reviews")
public class ReviewController
{
    @Autowired
    private ReviewRepository service;

    @CrossOrigin
    @GetMapping
    public Iterable<ReviewModel> findAllReview() {
        return service.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<ReviewModel> findReviewById(@PathVariable(value = "id") int id) {
        Optional<ReviewModel> review = service.findById(id);

        return review.map(reviewModel -> ResponseEntity.ok().body(reviewModel)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewModel create(@Valid @RequestBody ReviewModel reviewModel) {
        return service.save(reviewModel);
    }

    @PutMapping("/{id}")
    public ReviewModel replaceEmployee(@RequestBody ReviewModel reviewModel, @PathVariable int id) {
        return service.findById(id)
                .map(review -> {
                    review.setUid(reviewModel.getUid());
                    review.setProfile(reviewModel.getProfile());
                    review.setAnime_uid(reviewModel.getAnime_uid());
                    review.setScore(reviewModel.getScore());
                    review.setLink(reviewModel.getLink());

                    return service.save(review);
                })
                .orElseGet(() -> {
                    reviewModel.setUid(id);
                    return service.save(reviewModel);
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
