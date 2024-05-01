package com.example.bingocastrobackend.Controller.Dashboard;


import com.example.bingocastrobackend.Model.Dashboard.Dashboard;
import com.example.bingocastrobackend.Model.Dashboard.DashboardRequest;
import com.example.bingocastrobackend.Model.Dashboard.GameLetter;
import com.example.bingocastrobackend.Model.Dashboard.GameLetterRequest;
import com.example.bingocastrobackend.Service.Dashboard.DashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/bingo/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @PostMapping("/newGame")
    public Dashboard createGame(@RequestBody DashboardRequest dashboardRequest) {
        Dashboard dashboard = new Dashboard();
        dashboard.setGameCode(dashboardRequest.getGameCode());

        List<GameLetter> gameLetters = new ArrayList<>();
        for (GameLetterRequest gameLetterRequest : dashboardRequest.getGameLetterRequests()){
            GameLetter gameLetter = new GameLetter();
            gameLetter.setGameLetter(gameLetterRequest.getGameLetter());
            gameLetter.setGameNumbers(gameLetterRequest.getGameNumbers());

            //Set Dashboard association for each Dashboard
            gameLetter.setDashboard(dashboard);
            gameLetters.add(gameLetter);

        }

        dashboard.setGameLetters(gameLetters);

        return dashboardService.createDashboard(dashboard);
    }

    @GetMapping("/{id}")
    public Optional<Dashboard> getGameCodeById(@PathVariable int id){
        return dashboardService.getDashboardById(id);
    }

    @GetMapping("/bCode={gameCode}")
    public Dashboard getDashboardByGameCode(@PathVariable String gameCode){
        return dashboardService.getDashboardByGameCode(gameCode);
    }


    @PostMapping("addNewNumber")
    public ResponseEntity<String> addNumberToDashboard(@RequestBody Map<String, Object> requestBody){
        String gameCode = (String) requestBody.get("gameCode");
        String gameLetter  = (String) requestBody.get("gameLetter");
        Integer newNumber = (Integer) requestBody.get("newNumber");

        dashboardService.addNumberToGame(gameCode, gameLetter, newNumber);
        return ResponseEntity.status(HttpStatus.OK).body("Number " + newNumber + " added to Dashboard with code " + gameCode + "and Letter: " + gameLetter);
    }


}



