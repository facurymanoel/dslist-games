package com.devs.superior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devs.superior.dslist.dto.GameDTO;
import com.devs.superior.dslist.dto.GameMinDTO;
import com.devs.superior.dslist.entities.Game;
import com.devs.superior.dslist.projections.GameMinProjection;
import com.devs.superior.dslist.repositories.GameReposiory;

@Service
public class GameService {
	@Autowired
	private GameReposiory gameReposiory;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameReposiory.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	 @Transactional(readOnly = true)
	 public List<GameMinDTO> findAll(){
		 var result = gameReposiory.findAll();
		 List<GameMinDTO> dto = result.stream()
				                      .map(x -> new GameMinDTO(x))
				                      .toList();
		 return dto;
	 }
	 
	 @Transactional(readOnly = true)
	 public List<GameMinDTO> findByList(Long listId){
		 List<GameMinProjection> result = gameReposiory.searchByList(listId);
		 List<GameMinDTO> dto = result.stream()
				                      .map(x -> new GameMinDTO(x))
				                      .toList();
		 
		 return dto;
		 
	 }
	 
	
	

}
