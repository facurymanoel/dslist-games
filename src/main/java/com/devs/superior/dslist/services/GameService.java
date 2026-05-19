package com.devs.superior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devs.superior.dslist.dto.GameMinDTO;
import com.devs.superior.dslist.repositories.GameReposiory;

@Service
public class GameService {
	@Autowired
	private GameReposiory gameReposiory;
	
	 @Transactional(readOnly = true)
	 public List<GameMinDTO> findAll(){
		 var result = gameReposiory.findAll();
		 List<GameMinDTO> dto = result.stream()
				                      .map(x -> new GameMinDTO(x))
				                      .toList();
		 return dto;
	 }
	
	

}
