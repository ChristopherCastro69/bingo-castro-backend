package com.example.bingocastrobackend.Repository;

import com.example.bingocastrobackend.Model.BingoLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BingoLetterRepository extends JpaRepository<BingoLetter, Integer> {
    // Define custom query methods if needed
}