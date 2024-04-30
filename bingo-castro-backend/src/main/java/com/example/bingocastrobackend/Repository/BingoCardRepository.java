package com.example.bingocastrobackend.Repository;

import com.example.bingocastrobackend.Model.BingoCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BingoCardRepository extends JpaRepository<BingoCard, Integer> {
    // Define custom query methods if needed
}

