package eTicatetHomework;


import eTicatetHomework.business.abstracts.UserService;

import eTicatetHomework.business.concretes.UserManager;
import eTicatetHomework.dataAccess.concretes.HibernateUserDao;
import eTicatetHomework.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		UserService userService = new UserManager(new HibernateUserDao());
		User user1 = new User(1,"Yunus Emre","Duymaz","yemreduymaz@hotmail.com","123456");
		User user2 = new User(1,"Yunus Emre","Duymaz","yemreduymaz@gmail.com","123456");
		User user3 = new User(1,"Y","D","yemreduymaz@hotmail.com","123");
		User user4 = new User(1,"YE","Duymaz","yemreduymaz","12345");
		User user5 = new User(1,"Yunus Emre","Duymaz","yemred@gmail.com","123456");
		
		System.out.println(userService.register(user3));
		System.out.println(userService.register(user4));
		System.out.println(userService.register(user1));
		System.out.println(userService.register(user5));
		System.out.println(userService.register(user2));
		
		
		userService.logIn("yemred@gmail.com", "123456");
		
			

	}

}
