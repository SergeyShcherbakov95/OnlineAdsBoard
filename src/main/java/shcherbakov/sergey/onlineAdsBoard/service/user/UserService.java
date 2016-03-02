package shcherbakov.sergey.onlineAdsBoard.service.user;

import shcherbakov.sergey.onlineAdsBoard.model.User;

/**
 * @author sergey.shcherbakov
 *
 */
public interface UserService {
	public User find(String email);
	
	public void addUser(User user);
	
	public User getUser(Integer idUser);
}
