package eTicatetHomework.dataAccess.abstracts;

import java.util.List;

import eTicatetHomework.entities.concretes.User;

public interface UserDao {

	boolean register(User user);
	List<User> getAll();
	User get(User user);
	void delete(User user); 
	User getUserByEmail(String email);
	
}
