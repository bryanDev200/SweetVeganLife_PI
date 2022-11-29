package com.sweet.service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.sweet.dto.SaveUserDTO;
import com.sweet.entity.Document;
import com.sweet.entity.Rol;
import com.sweet.entity.Shoop;
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

	@Override
	public String updateUser(SaveUserDTO user, long id) {
		User userFound = userDAO.findById(id).orElse(null);
		
		if(userFound != null) {
			userFound.setUserImage(user.getImage());
			userFound.setUserLastName(user.getLastName());
			userFound.setUserFirstNames(user.getFirstName());
			userFound.setUserPhone(user.getPhone());
			userFound.setDocument(new Document(user.getDocumentId()));
			userFound.setShoop(new Shoop(user.getShoopId()));
			userFound.setUserRol(new Rol(user.getRolId()));
			userFound.setEnabledUser(user.isEnabled());
			
			User userSave = userDAO.save(userFound);
			if(userSave == null) {
				return "Error al actualizar los datos";
			}else {
				return "El usuario " + user.getFirstName() + " ha sido editado correctamente";
			}
		}else {
			return "El usuario no ha sido encontrado";
		}
	}
}