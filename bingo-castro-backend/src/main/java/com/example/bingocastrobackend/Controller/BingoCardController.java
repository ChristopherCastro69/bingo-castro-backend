package com.example.bingocastrobackend.Controller;

import com.example.bingocastrobackend.Model.BingoCard;
import com.example.bingocastrobackend.Model.BingoCardRequest;
import com.example.bingocastrobackend.Model.BingoLetter;
import com.example.bingocastrobackend.Model.BingoLetterRequest;
import com.example.bingocastrobackend.Service.BingoCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/bingo/")
public class BingoCardController {

    @Autowired
    private BingoCardService bingoCardService;

//    @PostMapping("/addBingoCard")
//    public BingoCard createBingoCard(@RequestBody BingoCard bingoCard) {
//        return bingoCardService.createBingoCard(bingoCard);
//    }

    @PostMapping("/addBingoCard")
    public BingoCard createBingoCard(@RequestBody BingoCardRequest bingoCardRequest) {
        // Create BingoCard object
        BingoCard bingoCard = new BingoCard();
        bingoCard.setPlaycardToken(bingoCardRequest.getPlaycardToken());

        // Create BingoLetter objects
        List<BingoLetter> bingoLetters = new ArrayList<>();
        for (BingoLetterRequest letterRequest : bingoCardRequest.getBingoLetters()) {
            BingoLetter letter = new BingoLetter();
            letter.setLetter(letterRequest.getLetter());
            letter.setNumbers(letterRequest.getNumbers());
            // Set BingoCard association for each BingoLetter
            letter.setBingoCard(bingoCard);
            bingoLetters.add(letter);
        }

        // Set BingoLetters to BingoCard
        bingoCard.setBingoLetters(bingoLetters);

        // Save BingoCard object along with associated BingoLetter objects
        return bingoCardService.createBingoCard(bingoCard);
    }


    @GetMapping("/getBingoCard/{id}")
    public BingoCard getBingoCardById(@PathVariable int id) {
        return bingoCardService.getBingoCardById(id);
    }

    @GetMapping("/getCard/{playcardToken}")
    public BingoCard getBingoCardByToken(@PathVariable String playcardToken){
        return bingoCardService.getBingoCardByToken(playcardToken);
    }
    // Other CRUD endpoints for BingoCard
}
