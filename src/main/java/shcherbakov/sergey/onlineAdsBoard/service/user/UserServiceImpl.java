package shcherbakov.sergey.onlineAdsBoard.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shcherbakov.sergey.onlineAdsBoard.dao.user.UserDao;
import shcherbakov.sergey.onlineAdsBoard.model.User;

/**
 * @author sergey.shcherbakov
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	 
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
	
    @Transactional
    @Override
	public User find(String email){
		return this.userDao.find(email);
	}
    
    @Transactional
    @Override
    public void addUser(User user){
    	this.userDao.addUser(user);
    }
    
    @Transactional
    @Override
    public User getUser(Integer idUser){
    	return this.userDao.getUser(idUser);
    }
}
