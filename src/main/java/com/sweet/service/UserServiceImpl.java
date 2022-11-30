package com.sweet.service;

	import java.util.List;
	import java.util.stream.Collectors;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.sweet.dto.SaveUserDTO;
import com.sweet.dto.UserListItemDTO;
import com.sweet.entity.Document;
	import com.sweet.entity.Rol;
	import com.sweet.entity.Shoop;
	import com.sweet.entity.User;
	import com.sweet.repository.UserDAO;
	import com.sweet.service.interfaces.IUserService;
	import com.sweet.utils.UserModelMapper;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User getUserByUsername(String username) {
		return userDAO.findByUserName(username).orElse(null);
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
	
	@Override
	public String deleteUser(long id) {
		User userFound = userDAO.findById(id).orElse(null);
		
		if(userFound != null) {
			try {
				userDAO.deleteById(id);
				return "Usuario eliminado correctamente";
			}catch(Exception e) {
				return "Error al eliminar usuario";
			}
		}else {
			return "El usuario no ha sido encontrado";
		}
	}

	@Override
	public User getUserById(long id) {
		try {
			User user = userDAO.findById(id).get();
			return user;
		}catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public List<UserListItemDTO> getAllUsers(String names, int roleId, int shoopId) {
		List<UserListItemDTO> data = userDAO.getAllUserFilters(names, roleId, shoopId).stream()
				.map((user) -> new UserListItemDTO((int)user.getUserId(), user.getUserFirstNames(),
						user.getUserLastName(), user.getUserRol().getRolDescription(),
						user.getUserPhone(), user.getDniNumber())).collect(Collectors.toList());
		return data;
	}
}