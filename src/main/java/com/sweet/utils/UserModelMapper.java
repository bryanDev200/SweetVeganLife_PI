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
	
	public static SaveUserDTO mapToDto(User user) {
		SaveUserDTO dto = new SaveUserDTO();
		
		dto.setDocNumber(user.getDniNumber());
		dto.setPassword(user.getPassword());
		dto.setImage(user.getUserImage());
		dto.setLastName(user.getUserLastName());
		dto.setFirstName(user.getUserFirstNames());
		dto.setUserName(user.getUserName());
		dto.setPhone(user.getUserPhone());
		dto.setDocumentId((int)user.getDocument().getDocumentId());
		dto.setShoopId((int)user.getShoop().getShoopId());
		dto.setRolId((int)user.getUserRol().getRolId());
		dto.setEnabled(user.isEnabledUser());
		
		return dto;
	}
}