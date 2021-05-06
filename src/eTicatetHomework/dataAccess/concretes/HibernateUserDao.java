package eTicatetHomework.dataAccess.concretes;

import java.util.List;

import eTicatetHomework.dataAccess.abstracts.UserDao;
import eTicatetHomework.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public boolean register(User user) {
		System.out.println("Sisteme Baþarýlý bir þekilde kayýt yapýldý");
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
		// Kullaným doðru deðildir null dönmemesi için simulasyon yaptým normalde DB den gelecek burda nesne oluþturmýcaz
		User user = new User(1,"Yunus Emre","Duymaz","yemred@gmail.com","123456");
		return user;
	}

}
