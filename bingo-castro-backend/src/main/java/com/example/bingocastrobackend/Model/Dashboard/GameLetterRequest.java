package com.example.bingocastrobackend.Model.Dashboard;

import java.util.List;

public class GameLetterRequest {
    private String gameLetter;
    private List<Integer> gameNumbers;

    public GameLetterRequest(String gameLetter, List<Integer> gameNumbers) {
        this.gameLetter = gameLetter;
        this.gameNumbers = gameNumbers;
    }

    public String getGameLetter() {
        return gameLetter;
    }

    public void setGameLetter(String gameLetter) {
        this.gameLetter = gameLetter;
    }

    public List<Integer> getGameNumbers() {
        return gameNumbers;
    }
    public void setGameNumbers(List<Integer> gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

}
