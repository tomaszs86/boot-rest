package pl.boot.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.boot.rest.domain.User;

@Service
public interface UserService {
	List<User> findAll();
	User findOne(Integer userId);
	void delete(Integer userId);
	User findByUsername(User user);
	void save(User user);
}
