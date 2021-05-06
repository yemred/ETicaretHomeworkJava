package eTicatetHomework.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import eTicatetHomework.business.abstracts.UserService;
import eTicatetHomework.dataAccess.abstracts.UserDao;
import eTicatetHomework.entities.concretes.User;

public class UserManager implements UserService {

	UserDao userDao;
	
	
	/**
	 * @param userDao
	 */
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;

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
		
		return userDao.getUserByEmail(email);
	}

	@Override
	public String register(User user) {
		
		String message="";
		
		if(user.getName().length()<2 && user.getLastName().length()<2) {
			message = "Ad ve Soyad en az 2 karakterden olmalýdýr";
			return message;
		}
		if(user.getPassword().length() < 6) {
			message = "Parola en az 6 karakterden oluþmalýdýr";
			return message;
		}
		if(!isGmailAddress(user.getEmail())) {
			message = "Email gmail ve email formatýnda olmalýdýr.";
			return message;
		}
		if(getUserByEmail(user.getEmail()).getEmail() == user.getEmail()) {
			message = "Sisteme bu kullanýcý zaten kayýtlý";
			return message;
		}
		
		if(userDao.register(user)) {
			message = sendEmail(user);
			
		}
	
		return message;
		
		
	}
	@Override
	public boolean logIn(String email, String password) {
		
		if(email == "" || password =="") {
			System.out.println("Email alaný veya Þifre alaný boþ býrakýlamaz ");
			return false;
		}
		if(!isGmailAddress(email)) {
			System.out.println("Email, gmail ve email formatýnda olmalýdýr ");
			return false;
		}
		
		User result = userDao.getUserByEmail(email);  
		
		if(result.getEmail() == email && result.getPassword() == password) {
			System.out.println("Sisteme Baþarýtla giriþ yapýldý.");
			return true;
		}else {
			System.out.println("Email veya Þifre Hatalý");
			return false;
		}
		
	}
	
	
	private String sendEmail(User user) {
		String message="";
		message = user.getName()+" adlý kullanýcý baþarýyla kayýt olmuþtur. "+user.getEmail()+" adresine email gönderilmiþtir.";
		return message;
		
	}
	
	 private static boolean isGmailAddress(String emailAddress) {
	        String expression = "^[\\w.+\\-]+@gmail\\.com$";
	        CharSequence inputStr = emailAddress;
	        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(inputStr);
	        return matcher.matches();
	    }


	

}
