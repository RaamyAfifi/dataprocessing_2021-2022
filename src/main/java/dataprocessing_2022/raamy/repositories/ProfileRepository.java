package dataprocessing_2022.raamy.repositories;

import dataprocessing_2022.raamy.models.ProfileModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<ProfileModel, String>
{}
