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
			message = "Ad ve Soyad en az 2 karakterden olmal�d�r";
			return message;
		}
		if(user.getPassword().length() < 6) {
			message = "Parola en az 6 karakterden olu�mal�d�r";
			return message;
		}
		if(!isGmailAddress(user.getEmail())) {
			message = "Email gmail ve email format�nda olmal�d�r.";
			return message;
		}
		if(getUserByEmail(user.getEmail()).getEmail() == user.getEmail()) {
			message = "Sisteme bu kullan�c� zaten kay�tl�";
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
			System.out.println("Email alan� veya �ifre alan� bo� b�rak�lamaz ");
			return false;
		}
		if(!isGmailAddress(email)) {
			System.out.println("Email, gmail ve email format�nda olmal�d�r ");
			return false;
		}
		
		User result = userDao.getUserByEmail(email);  
		
		if(result.getEmail() == email && result.getPassword() == password) {
			System.out.println("Sisteme Ba�ar�tla giri� yap�ld�.");
			return true;
		}else {
			System.out.println("Email veya �ifre Hatal�");
			return false;
		}
		
	}
	
	
	private String sendEmail(User user) {
		String message="";
		message = user.getName()+" adl� kullan�c� ba�ar�yla kay�t olmu�tur. "+user.getEmail()+" adresine email g�nderilmi�tir.";
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
