package com.sweet.service.interfaces;

	import com.sweet.dto.SaveUserDTO;
	import com.sweet.entity.User;

public interface IUserService {
	public User getUserByUsername(String username);
	public User saveUser(SaveUserDTO user);
	public String updateUser(SaveUserDTO user, long id);
}