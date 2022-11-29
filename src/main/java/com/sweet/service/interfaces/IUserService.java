package com.sweet.service.interfaces;

	import java.util.List;

	import com.sweet.dto.SaveUserDTO;
	import com.sweet.dto.UserListItemDTO;
	import com.sweet.entity.User;

public interface IUserService {
	public User getUserByUsername(String username);
	public User saveUser(SaveUserDTO user);
	public String updateUser(SaveUserDTO user, long id);
	public String deleteUser(long id);
	public User getUserById(long id);
	public List<UserListItemDTO> getAllUsers(String names, int roleId, int shoopId);
}