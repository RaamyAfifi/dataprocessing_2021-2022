package dataprocessing_2022.raamy.repositories;

import dataprocessing_2022.raamy.models.ReviewModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<ReviewModel, Integer>
{}
