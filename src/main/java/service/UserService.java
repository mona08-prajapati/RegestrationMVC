package service;

import bean.User;
import constants.UserConstants;
import dao.UserDao;

public class UserService {
	private UserDao userdao=new UserDao();

	public String authenticateAndPopulateUser(User user1) {
		String error=null;
		user1=UserDao.getUser(user1);
		if(user1.getFirstname()==null) {
			error=UserConstants.INVALID_USER_CREDENTIAL;
		}
		return error;
	}

	public String authenticateAndPopulateUser1(User user) {
		String error=null;
	user=UserDao.getUser1(user);
		if(user.getFirstname()==null) {
			error=UserConstants.INVALID_LOGIN;
	}
	return error;
}

	
}
