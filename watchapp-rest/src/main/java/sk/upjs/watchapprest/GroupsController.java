package sk.upjs.watchapprest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sk.upjs.watchapp.storage.DaoFactory;
import sk.upjs.watchapp.storage.EntityNotFoundException;
import sk.upjs.watchapp.storage.Genres;
import sk.upjs.watchapp.storage.GenresDao;
import sk.upjs.watchapp.storage.Groups;
import sk.upjs.watchapp.storage.GroupsDao;
import sk.upjs.watchapp.storage.User;
import sk.upjs.watchapp.storage.UserDao;

@RestController
@RequestMapping("/groups")
public class GroupsController {

	private GroupsDao groupsDao = DaoFactory.INSTANCE.getGroupsDao();
	private UserDao userDao = DaoFactory.INSTANCE.getUserDao();
	
	
	@GetMapping()
	public List<Groups> getAllGroups() {
		return groupsDao.getAll();
	}

	@GetMapping("{id}")
	public List<Groups> getGroups(@PathVariable("id") long idUser) {
//		 List<User> allUsers = userDao.getAll();
//		List<Groups> result = new ArrayList<>();
//		for (User user: allUsers) {
//			if (user.getId() == idUser) {
//			 result = groupsDao.getByUser(user);
//			}
//		}
//		return result;
		return groupsDao.getByUser(userDao.getById(idUser));

	}


	@PostMapping()
	public Groups saveGroup(@RequestBody Groups group) throws EntityNotFoundException, NullPointerException {

		return groupsDao.save(group);
	}
	
	
	// DOROBENE, funkcne
	@DeleteMapping("{id}")
	public boolean deleteGroups(@PathVariable("id") long idGroup) {
		return groupsDao.delete(idGroup);
		
	}
}
