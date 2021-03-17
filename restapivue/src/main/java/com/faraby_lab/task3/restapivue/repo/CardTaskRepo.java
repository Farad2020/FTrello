package com.faraby_lab.task3.restapivue.repo;

import com.faraby_lab.task3.restapivue.entities.CardTasks;
import com.faraby_lab.task3.restapivue.entities.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardTaskRepo extends JpaRepository<CardTasks, Long> {

    List<CardTasks> findAllByCardId(Long cardId);
}
