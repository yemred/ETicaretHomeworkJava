package eTicatetHomework.business.abstracts;

import java.util.List;

import eTicatetHomework.entities.concretes.User;

public interface UserService {
	
	String register(User user);
	List<User> getAll();
	User get(User user);
	void delete(User user);
	User getUserByEmail(String email);
	boolean logIn(String email, String password);


}
