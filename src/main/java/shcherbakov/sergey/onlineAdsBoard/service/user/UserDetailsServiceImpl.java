package shcherbakov.sergey.onlineAdsBoard.service.user;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shcherbakov.sergey.onlineAdsBoard.dao.user.UserDao;
import shcherbakov.sergey.onlineAdsBoard.model.User;

/**
 * @author sergey.shcherbakov
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
	
    @Transactional
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = this.userDao.find(email);
		if (user == null)
			throw new UsernameNotFoundException("User with given email " + email + " isn't found. ");
		
		return new UserDetailsImpl(user);
	}

	private static class UserDetailsImpl extends User implements UserDetails {
		
		private static final long serialVersionUID = 1L;
		
		public UserDetailsImpl(User user){
			super(user.getEmail(), user.getUserPassword(), user.getSurname(), user.getName(), user.getSex(), user.getImageUser());
		}
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			Collection<GrantedAuthority> authorities = new LinkedList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			return authorities;
		}

		@Override
		public String getUsername() { return getEmail(); }
		
		@Override
		public String getPassword() { return getUserPassword(); }

		@Override
		public boolean isAccountNonExpired() { return true; }

		@Override
		public boolean isAccountNonLocked() { return true; }

		@Override
		public boolean isCredentialsNonExpired() { return true; }

		@Override
		public boolean isEnabled() { return true; }
	}
}
