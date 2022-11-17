package com.sweet.service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.sweet.dto.SaveUserDTO;
	import com.sweet.entity.User;
	import com.sweet.repository.IUserDAO;
	import com.sweet.service.interfaces.IUserService;
	import com.sweet.utils.UserModelMapper;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDAO userDAO;
	
	@Override
	public User getUserByUsername(String username) {
		return userDAO.findByUserName(username).get();
	}

	@Override
	public User saveUser(SaveUserDTO user) {
		return userDAO.save(UserModelMapper.mapToEntity(user));
	}
}