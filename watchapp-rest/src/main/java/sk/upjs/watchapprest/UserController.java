package sk.upjs.watchapprest;

import java.util.List;

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
import sk.upjs.watchapp.storage.User;
import sk.upjs.watchapp.storage.UserDao;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserDao userDao = DaoFactory.INSTANCE.getUserDao();

	@GetMapping()
	public List<User> getAllUsers() {
		return userDao.getAll();
	}

	@PostMapping()
	public User saveUser(@RequestBody User user) throws EntityNotFoundException, NullPointerException {

		return userDao.save(user);
	}
	
	// DOROBENE, nevie mazat kvoli FK, ale ak pridam noveho usera, ktory nie je navizany tak to ide v pohode
	@DeleteMapping("{id}")
	public User deleteUser(@PathVariable("id") long idUser) throws EntityNotFoundException, EntityUndeletableException {
		return userDao.delete(idUser);
	}
}
