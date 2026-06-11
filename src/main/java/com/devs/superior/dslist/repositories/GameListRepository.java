package com.devs.superior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devs.superior.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList,Long> {

}
