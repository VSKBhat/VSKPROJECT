package com.ihub.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ihub.model.Director;
import com.ihub.model.Movie;

public interface MovieRepository extends MongoRepository<Director, Integer>{
	public List<Director> findDirectorByMovies_title(String title);
	public List<Director> findDirectorByFname(String fname);
	public String deleteDirectorByMovies_title(String title);
}
