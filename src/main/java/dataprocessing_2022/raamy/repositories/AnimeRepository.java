package dataprocessing_2022.raamy.repositories;

import dataprocessing_2022.raamy.models.AnimeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends CrudRepository<AnimeModel, Integer>
{}


