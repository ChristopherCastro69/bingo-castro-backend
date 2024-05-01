package com.example.bingocastrobackend.Service;

import com.example.bingocastrobackend.Model.BingoCard;
import com.example.bingocastrobackend.Repository.BingoCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BingoCardService {

    private final BingoCardRepository bingoCardRepository;

    public BingoCardService(BingoCardRepository bingoCardRepository) {
        this.bingoCardRepository = bingoCardRepository;
    }

    public BingoCard createBingoCard(BingoCard bingoCard) {
        // Implement validation or business logic if needed
        return bingoCardRepository.save(bingoCard);
    }

    public BingoCard getBingoCardById(int id) {
        // Implement error handling if necessary
        return bingoCardRepository.findById(id).orElse(null);
    }

    public BingoCard getBingoCardByToken(String token) {
        return bingoCardRepository.getBingoCardByToken(token);
    }

    public List<String> getAllPlaycardTokens() {
        return bingoCardRepository.findAllPlaycardTokens();
    }
    // Other methods for CRUD operations or business logic related to BingoCard
}
