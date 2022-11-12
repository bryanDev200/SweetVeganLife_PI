package com.sweet.utils;

	import com.sweet.dto.SaveUserDTO;
	import com.sweet.entity.Document;
	import com.sweet.entity.Rol;
	import com.sweet.entity.Shoop;
	import com.sweet.entity.User;

public class UserModelMapper {
	public static User mapToEntity(SaveUserDTO dto) {
		User user = new User();
		
		user.setDniNumber(dto.getDocNumber());
		user.setPassword(dto.getPassword());
		user.setUserImage(dto.getImage());
		user.setUserLastName(dto.getLastName());
		user.setUserFirstNames(dto.getFirstName());
		user.setUserName(dto.getUserName());
		user.setUserPhone(dto.getPhone());
		user.setDocument(new Document(dto.getDocumentId()));
		user.setShoop(new Shoop(dto.getShoopId()));
		user.setUserRol(new Rol(dto.getRolId()));
		user.setEnabledUser(dto.isEnabled());
		
		return user;
	}
}