package com.sweet.service.interfaces;

	import java.util.List;
	
	import com.sweet.dto.DocumentUserDTO;

public interface IDocumentService {
	public List<DocumentUserDTO> getDocuments();
}