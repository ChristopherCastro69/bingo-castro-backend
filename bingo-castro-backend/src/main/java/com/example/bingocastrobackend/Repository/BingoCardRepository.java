package com.example.bingocastrobackend.Repository;

import com.example.bingocastrobackend.Model.BingoCard;
import com.example.bingocastrobackend.Model.BingoDashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BingoCardRepository extends JpaRepository<BingoCard, Integer> {
    // Define custom query methods if needed
    @Query("SELECT token FROM BingoCard token WHERE token.playcardToken = :playcardToken")
    BingoCard getBingoCardByToken(@Param("playcardToken") String playcardToken);

    @Query("SELECT DISTINCT bc.playcardToken FROM BingoCard bc")
    List<String> findAllPlaycardTokens();
}

