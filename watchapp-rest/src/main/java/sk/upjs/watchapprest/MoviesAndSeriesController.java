package sk.upjs.watchapprest;

import java.util.List;

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
import sk.upjs.watchapp.storage.MoviesAndSeries;
import sk.upjs.watchapp.storage.MoviesAndSeriesDao;

// FUNGUJE CELA TRIEDA

@CrossOrigin
@RestController
@RequestMapping("/moviesandseries")
public class MoviesAndSeriesController {

	private MoviesAndSeriesDao moviesandseriesDao = DaoFactory.INSTANCE.getMoviesAndSeriesDao();

	@GetMapping()
	public List<MoviesAndSeries> getAllMoviesAndSeries() {
		return moviesandseriesDao.getAll();
	}
	
	
	@GetMapping("{id}")
	public List<MoviesAndSeries> getMoviesAndSeries(@PathVariable("id") long idGenre) {
//		 List<User> allUsers = userDao.getAll();
//		List<Groups> result = new ArrayList<>();
//		for (User user: allUsers) {
//			if (user.getId() == idUser) {
//			 result = groupsDao.getByUser(user);
//			}
//		}
//		return result;
		return moviesandseriesDao.getByGenreId(idGenre);

	}

	@PostMapping()
	public MoviesAndSeries saveMoviesAndSeries(@RequestBody MoviesAndSeries movieandserie)
			throws EntityNotFoundException, NullPointerException {
		return moviesandseriesDao.save(movieandserie);
	}

	@DeleteMapping("{id}")
	public MoviesAndSeries deleteMovieAndSerie(@PathVariable("id") long idMovieAndSerie)
			throws EntityNotFoundException, EntityUndeletableException {
		return moviesandseriesDao.delete(idMovieAndSerie);
	}

}
