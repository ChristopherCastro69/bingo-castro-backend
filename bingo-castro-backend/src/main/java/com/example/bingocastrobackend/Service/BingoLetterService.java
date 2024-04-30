package com.example.bingocastrobackend.Service;

import com.example.bingocastrobackend.Model.BingoLetter;
import com.example.bingocastrobackend.Repository.BingoLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BingoLetterService {

    @Autowired
    private BingoLetterRepository bingoLetterRepository;

    public BingoLetter createBingoLetter(BingoLetter bingoLetter) {
        // Implement validation or business logic if needed
        return bingoLetterRepository.save(bingoLetter);
    }

    public BingoLetter getBingoLetterById(int id) {
        // Implement error handling if necessary
        return bingoLetterRepository.findById(id).orElse(null);
    }

    // Other methods for CRUD operations or business logic related to BingoLetter
}