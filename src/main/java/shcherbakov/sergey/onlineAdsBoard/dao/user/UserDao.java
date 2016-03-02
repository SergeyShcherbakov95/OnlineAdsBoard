package shcherbakov.sergey.onlineAdsBoard.dao.user;

import shcherbakov.sergey.onlineAdsBoard.model.User;

/**
 * @author sergey.shcherbakov
 *
 */
public interface UserDao {
	public User find(String email);
	
	public void addUser(User user);
	
	public User getUser(Integer idUser);
}
