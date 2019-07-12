package service;

import java.sql.SQLException;

import damain.User;
import dao.UserDao;
public class UserService {
	UserDao userDao = new UserDao();

	public boolean Login(User user) {
		try {
			return userDao.Login(user);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
