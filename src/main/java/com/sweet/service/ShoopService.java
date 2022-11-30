package com.sweet.service;

	import java.util.List;
	import java.util.stream.Collectors;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.sweet.dto.ShoopUserDTO;
	import com.sweet.repository.ShoopDAO;
	import com.sweet.service.interfaces.IShoopService;

@Service
public class ShoopService implements IShoopService {
	@Autowired
	private ShoopDAO repo;
	
	@Override
	public List<ShoopUserDTO> getShoops() {
		List<ShoopUserDTO> data = repo.findAll().stream()
				.map((shoop) -> new ShoopUserDTO(shoop.getShoopId(), shoop.getAddress())).collect(Collectors.toList());
		return data;
	}
}