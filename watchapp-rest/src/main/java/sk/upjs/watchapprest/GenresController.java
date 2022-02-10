package sk.upjs.watchapprest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.upjs.watchapp.storage.DaoFactory;
import sk.upjs.watchapp.storage.EntityNotFoundException;
import sk.upjs.watchapp.storage.EntityUndeletableException;
import sk.upjs.watchapp.storage.Genres;
import sk.upjs.watchapp.storage.GenresDao;

@CrossOrigin
@RestController
@RequestMapping("/genres")
public class GenresController {

	private GenresDao genresDao = DaoFactory.INSTANCE.getGenresDao();

	@GetMapping()
	public List<Genres> getAllGenres() {
		return genresDao.getAll();
	}
	
	@GetMapping("{id}")
	public Genres getById(@PathVariable("id") Long id) {
		return genresDao.getById(id);
	}

//	@PostMapping()
//	public Genres saveGenre(@RequestBody Genres genre) throws EntityNotFoundException, NullPointerException {
//
//		return genresDao.save(genre);
//	}
	
	
	@PostMapping()
	public ResponseEntity<Genres> saveGenre(@RequestBody Genres genre) throws EntityNotFoundException, NullPointerException {
		if (genre.getId() == null) {
			return new ResponseEntity<Genres>(genresDao.save(genre), HttpStatus.CREATED);	
		} else {
			// ak uz aj s ID
			return new ResponseEntity<Genres>(genresDao.save(genre), HttpStatus.ACCEPTED);	

		}
		
	}
	
	@DeleteMapping("{id}")
	public Genres deleteGenre(@PathVariable("id") long idGenre) throws EntityNotFoundException, EntityUndeletableException {
		return genresDao.delete(idGenre);
	}

}
