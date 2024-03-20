package com.neosoft.service;

import com.neosoft.model.Card;
import com.neosoft.repository.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepo cardRepo;

    @Override
    public void createCard(Card card) {
      this.cardRepo.save(card);
    }
}
