package com.neosoft.controller;

import com.neosoft.model.Card;
import com.neosoft.service.CardService;
import com.neosoft.service.CardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
@CrossOrigin("*")
public class CardController {
    @Autowired
    private CardServiceImpl cardServiceImpl;


    @PostMapping("/createcard")
    public void createCard(@RequestBody Card card) throws Exception {

        this.cardServiceImpl.createCard(card);
    }

}
