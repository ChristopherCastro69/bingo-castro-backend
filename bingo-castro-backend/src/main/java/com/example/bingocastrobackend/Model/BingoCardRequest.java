package com.example.bingocastrobackend.Model;

import java.util.List;

public class BingoCardRequest {

    private String playcardToken;
    private List<BingoLetterRequest> bingoLetters;

    // Constructors, getters, and setters

    public BingoCardRequest(String playcardToken, List<BingoLetterRequest> bingoLetters) {
        this.playcardToken = playcardToken;
        this.bingoLetters = bingoLetters;
    }

    public String getPlaycardToken() {
        return playcardToken;
    }

    public void setPlaycardToken(String playcardToken) {
        this.playcardToken = playcardToken;
    }

    public List<BingoLetterRequest> getBingoLetters() {
        return bingoLetters;
    }

    public void setBingoLetters(List<BingoLetterRequest> bingoLetters) {
        this.bingoLetters = bingoLetters;
    }
}
