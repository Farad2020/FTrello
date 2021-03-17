package com.faraby_lab.task3.restapivue.services.impl;

import com.faraby_lab.task3.restapivue.entities.CardTasks;
import com.faraby_lab.task3.restapivue.entities.Cards;
import com.faraby_lab.task3.restapivue.repo.CardRepo;
import com.faraby_lab.task3.restapivue.repo.CardTaskRepo;
import com.faraby_lab.task3.restapivue.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepo cardRepo;
    @Autowired
    private CardTaskRepo cardTaskRepo;

    @Override
    public List<Cards> getAllCards() {
        return cardRepo.findAll();
    }

    @Override
    public Cards addCard(Cards card) {
        return cardRepo.save(card);
    }

    @Override
    public Cards saveCard(Cards card) {
        return cardRepo.save(card);
    }

    @Override
    public Cards getCardById(Long cardId) {
        return cardRepo.findFirstById(cardId);
    }

    @Override
    public List<CardTasks> getCardTasks(Long cardId) {
        return cardTaskRepo.findAllByCardId(cardId);
    }

    @Override
    public CardTasks addCardTask(CardTasks task) {
        return cardTaskRepo.save(task);
    }

    @Override
    public CardTasks saveCardTask(CardTasks task) {
        return cardTaskRepo.save(task);
    }

    @Override
    public void deleteCard(Cards card) {
        cardRepo.delete(card);
    }

    @Override
    public List<Cards> getCardsByName(String name) {
        return cardRepo.findAllByNameContains(name);
    }
}
