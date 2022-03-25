package dataprocessing_2022.raamy.controllers;

import dataprocessing_2022.raamy.models.ProfileModel;
import dataprocessing_2022.raamy.models.ReviewModel;
import dataprocessing_2022.raamy.repositories.ReviewRepository;
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
@RequestMapping(value = "/reviews", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class ReviewController
{
    @Autowired
    private ReviewRepository service;

    @CrossOrigin
    @GetMapping
    @ApiOperation(
            value = "Get all the reviews",
            notes = "",
            response = List.class )
    public Iterable<ReviewModel> findAllReview() {
        return service.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @ApiOperation(
            value = "Get a single review by Id. If you would like to select a specific review use following: http://localhost:8080/reviews/{id}",
            notes = "",
            response = List.class )
    public ResponseEntity<ReviewModel> findReviewById(@PathVariable(value = "id") int id) {
        Optional<ReviewModel> review = service.findById(id);

        return review.map(reviewModel -> ResponseEntity.ok().body(reviewModel)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewModel createReview(@Valid @RequestBody ReviewModel reviewModel) {
        return service.save(reviewModel);
    }

    @PutMapping("/{id}")
    @ApiOperation(
            value = "puts a review into the database",
            notes = "",
            response = List.class )
    public ReviewModel replaceReview(@RequestBody ReviewModel reviewModel, @PathVariable int id) {
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
    @ApiOperation(
            value = "Deletes a specific review by id. If you would like to delete a specific review use following: http://localhost:8080/review/{id}",
            notes = "",
            response = ProfileModel.class )
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
