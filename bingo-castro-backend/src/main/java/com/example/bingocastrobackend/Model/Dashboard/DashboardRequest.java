package com.example.bingocastrobackend.Model.Dashboard;

import java.util.List;

public class DashboardRequest {
    private String gameCode;
    private List<GameLetterRequest> gameLetterRequests;
    public DashboardRequest(String gameCode, List<GameLetterRequest> gameLetterRequests) {
        this.gameCode = gameCode;
        this.gameLetterRequests = gameLetterRequests;
    }

    public String getGameCode() {
        return gameCode;
    }
    public void setGameCode(String gameCode) {
        this.gameCode = gameCode;
    }

    public List<GameLetterRequest> getGameLetterRequests() {
        return gameLetterRequests;
    }
    public void setGameLetterRequests(List<GameLetterRequest> gameLetterRequests) {
        this.gameLetterRequests = gameLetterRequests;
    }

    
}
