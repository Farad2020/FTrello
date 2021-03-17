package com.faraby_lab.task3.restapivue.repo;

import com.faraby_lab.task3.restapivue.entities.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepo extends JpaRepository<Cards, Long> {

    Cards findFirstById(Long cardId);
    List<Cards> findAllByNameContains(String name);
}
