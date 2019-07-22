package com.ihub.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ihub.model.MovieNotFoundException;
import com.ihub.model.Director;
import com.ihub.model.DirectorNotFoundException;
import com.ihub.model.Movie;
import com.ihub.repository.MovieRepository;

@RestController
public class MovieController {
	@Autowired
	private MovieRepository mv;

	// insert director and movie details
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertMovie(@RequestBody Director d) {
		mv.save(d);
		return "Added movie with ID:" + d.getId();

	}

	// display all details
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Director> getAllMovie() {
		return mv.findAll();
	}

	// get movie and director details based on id
	@GetMapping("/getbyID/{id}")
	public Optional<Director> getMovies(@PathVariable Integer id) {
		// System.out.println("***"+id);
		return mv.findById(id);

	}

	// update movie or director details based on id
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public String updateMovie(@PathVariable(value = "id") int id, @RequestBody Director movie) {
		mv.save(movie);
		return "Updated successfully!";
	}

	// director details based on movie title
	@GetMapping("/getbytitle/{title}")
	public List<Director> getMoviebyTitle(@PathVariable String title) throws MovieNotFoundException {
		List<Director> list = null;
		try {
			list = mv.findDirectorByMovies_title(title);
			if(list.isEmpty())
			{
				throw new MovieNotFoundException();
			}

		} catch (MovieNotFoundException e1) {
			throw new MovieNotFoundException("Invalid Movie title :" + title);
		}
		return list;

	}

	// movies based on director name
	@GetMapping("/getbyname/{fname}")
	public List<Director> getMoviebyName(@PathVariable String fname) throws DirectorNotFoundException {
		List<Director> list2=null;
		try {
			list2=mv.findDirectorByFname(fname);
			if(list2.isEmpty())
			{
				throw new DirectorNotFoundException();
			}
		}
		catch(DirectorNotFoundException e2) {
			throw new DirectorNotFoundException("Invalid director name:"+fname);
		}
		return list2;
	}

	@DeleteMapping("/delete/{title}")
	public String deleteMovie(@PathVariable String title) {
		mv.deleteDirectorByMovies_title(title);
		return "deleted" + title;
	}
}
