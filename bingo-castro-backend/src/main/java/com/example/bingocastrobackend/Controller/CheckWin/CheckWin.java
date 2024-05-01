package com.example.bingocastrobackend.Controller.CheckWin;

import com.example.bingocastrobackend.Model.BingoCard;
import com.example.bingocastrobackend.Model.BingoLetter;
import com.example.bingocastrobackend.Model.Dashboard.Dashboard;
import com.example.bingocastrobackend.Model.Dashboard.GameLetter;
import com.example.bingocastrobackend.Service.BingoCardService;
import com.example.bingocastrobackend.Service.Dashboard.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/bingo/")
public class CheckWin {
    @Autowired
    private BingoCardService bingoCardService;

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/checkwin/{playcardToken}/bCode={gameCode}")
    public int compareCardtoDashboard(
            @PathVariable String playcardToken,
            @PathVariable String gameCode)
    {
        // Get bingo card by playcardToken
        BingoCard bingoCard = bingoCardService.getBingoCardByToken(playcardToken);

        // Get dashboard by gameCode
        Dashboard dashboard = dashboardService.getDashboardByGameCode(gameCode);


        // Check if both bingo card and dashboard exist
        if (bingoCard == null || dashboard == null) {
            // Return -1 if either bingo card or dashboard does not exist
            return -1;
        }

        // Iterate through each bingo letter in the bingo card
        for (BingoLetter bingoLetter : bingoCard.getBingoLetters()) {
            // Check if the letter exists in the dashboard
            if (dashboardContainsLetter(dashboard, bingoLetter)) {
                // Compare the numbers of the bingo letter and dashboard letter
                if (compareLetterNumbers(bingoLetter, dashboard.getGameLetters())) {
                    continue; // Move to the next letter
                } else {
                    // Return 0 if numbers don't match
                    return 0;
                }
            } else {
                // Return 0 if letter doesn't exist in the dashboard
                return 0;
            }
        }
        // If all letters match, return 1
        return 1;

    }


    // Helper method to check if the dashboard contains the bingo letter
    private boolean dashboardContainsLetter(Dashboard dashboard, BingoLetter bingoLetter) {
        // Iterate through game letters in the dashboard
        for (GameLetter gameLetter : dashboard.getGameLetters()) {
            // Check if the game letter matches the bingo letter
            if (gameLetter.getGameLetter().equals(bingoLetter.getLetter())) {
                return true;
            }
        }
        return false;
    }


    // Helper method to compare numbers of a bingo letter and dashboard letter
    private boolean compareLetterNumbers(BingoLetter bingoLetter, List<GameLetter> gameLetters) {
        // Find the corresponding game letter in the dashboard
        for (GameLetter gameLetter : gameLetters) {
            if (gameLetter.getGameLetter().equals(bingoLetter.getLetter())) {
                // Compare numbers
                return gameLetter.getGameNumbers().containsAll(bingoLetter.getNumbers());
            }
        }
        return false;
    }

//CheckBingo
@GetMapping("/checkBingo/{playcardToken}/bCode={gameCode}")
public int checkBingo(
        @PathVariable String playcardToken,
        @PathVariable String gameCode) {
    // Get bingo card by playcardToken
    BingoCard bingoCard = bingoCardService.getBingoCardByToken(playcardToken);

    // Get dashboard by gameCode
    Dashboard dashboard = dashboardService.getDashboardByGameCode(gameCode);

    // Check if both bingo card and dashboard exist
    if (bingoCard == null || dashboard == null) {
        // Return -1 if either bingo card or dashboard does not exist
        return -1;
    }

    // Get the map of bingo letters and their corresponding sets of numbers
    Map<String, Set<Integer>> bingoCardNumbers = getBingoCardNumbers(bingoCard);

    // Get the map of game letters and their corresponding sets of numbers
    Map<String, Set<Integer>> dashboardNumbers = getDashboardNumbers(dashboard);

    // Iterate through each bingo letter and check if it satisfies the conditions
    for (Map.Entry<String, Set<Integer>> entry : bingoCardNumbers.entrySet()) {
        String letter = entry.getKey();
        Set<Integer> bingoNumbers = entry.getValue();

        // Check if the dashboard numbers contain all numbers from the bingo card and vice versa
        if (dashboardNumbers.containsKey(letter) && dashboardNumbers.get(letter).containsAll(bingoNumbers) && bingoNumbers.containsAll(dashboardNumbers.get(letter))) {
            // Log comparison result including array of numbers and letters
            System.out.println("BingoCard " + playcardToken + " letter " + letter + " matches Dashboard " + gameCode +
                    ". BingoCard numbers: " + bingoNumbers + ", Dashboard numbers: " + dashboardNumbers.get(letter));
            return 1; // Return 1 if conditions are met
        }
    }

    System.out.println("No matching set found between BingoCard " + playcardToken + " and Dashboard " + gameCode);
    return 0;
}

    // Helper method to get the map of bingo letters and their corresponding sets of numbers
    private Map<String, Set<Integer>> getBingoCardNumbers(BingoCard bingoCard) {
        // Create a map to store bingo letter as key and set of numbers as value
        Map<String, Set<Integer>> bingoCardNumbers = bingoCard.getBingoLetters().stream()
                .collect(Collectors.toMap(
                        BingoLetter::getLetter,
                        bingoLetter -> new HashSet<>(bingoLetter.getNumbers())
                ));
        return bingoCardNumbers;
    }

    // Helper method to get the map of game letters and their corresponding sets of numbers from the dashboard
    private Map<String, Set<Integer>> getDashboardNumbers(Dashboard dashboard) {
        // Create a map to store game letter as key and set of numbers as value
        Map<String, Set<Integer>> dashboardNumbers = dashboard.getGameLetters().stream()
                .collect(Collectors.toMap(
                        GameLetter::getGameLetter,
                        gameLetter -> new HashSet<>(gameLetter.getGameNumbers())
                ));
        return dashboardNumbers;
    }
}
