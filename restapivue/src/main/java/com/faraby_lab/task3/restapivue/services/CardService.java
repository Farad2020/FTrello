package com.faraby_lab.task3.restapivue.services;

import com.faraby_lab.task3.restapivue.entities.CardTasks;
import com.faraby_lab.task3.restapivue.entities.Cards;

import java.util.List;

public interface CardService {

    List<Cards> getAllCards();
    List<Cards> getCardsByName(String name);
    Cards addCard(Cards card);
    Cards saveCard(Cards card);
    Cards getCardById(Long cardId);
    void deleteCard(Cards cards);

    List<CardTasks> getCardTasks(Long cardId);
    CardTasks addCardTask(CardTasks task);
    CardTasks saveCardTask(CardTasks task);

}
