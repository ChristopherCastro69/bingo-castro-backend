package com.example.bingocastrobackend.Model;

import java.util.List;

public class BingoLetterRequest {

    private String letter;
    private List<Integer> numbers;

    // Constructors, getters, and setters

    public BingoLetterRequest(String letter, List<Integer> numbers) {
        this.letter = letter;
        this.numbers = numbers;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
