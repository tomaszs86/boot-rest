package pl.boot.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.boot.rest.domain.User;
import pl.boot.rest.repository.UserRepository;
import pl.boot.rest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findOne(Integer userId) {
		return userRepository.findOne(userId);
	}
	
	public void delete(Integer userId) {
		userRepository.delete(userId);
	}
	
	public User findByUsername(User user) {
		return userRepository.findByUsername(user.getUsername());
	}
	
	public void save(User user) {
		userRepository.save(user);		
	}
	
	
	
}
