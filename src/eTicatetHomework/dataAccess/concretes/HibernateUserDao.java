package eTicatetHomework.dataAccess.concretes;

import java.util.List;

import eTicatetHomework.dataAccess.abstracts.UserDao;
import eTicatetHomework.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public boolean register(User user) {
		System.out.println("Sisteme Ba�ar�l� bir �ekilde kay�t yap�ld�");
		return true;
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserByEmail(String email) {
		// Kullan�m do�ru de�ildir null d�nmemesi i�in simulasyon yapt�m normalde DB den gelecek burda nesne olu�turm�caz
		User user = new User(1,"Yunus Emre","Duymaz","yemred@gmail.com","123456");
		return user;
	}

}
