package com.example.bingocastrobackend.Service.Dashboard;

import com.example.bingocastrobackend.Model.Dashboard.Dashboard;
import com.example.bingocastrobackend.Model.Dashboard.GameLetter;
import com.example.bingocastrobackend.Repository.Dashboard.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DashboardService {
    @Autowired
    private DashboardRepository dashboardRepository;

    public Dashboard createDashboard(Dashboard dashboard) {
        return dashboardRepository.save(dashboard);
    }

    public Dashboard getDashboardByGameCode(String gameCode) {
        return dashboardRepository.findByGameCode(gameCode);
    }

    public Optional<Dashboard> getDashboardById(int id) {
        return dashboardRepository.findById(id);
    }

    public Dashboard addNumberToGame(String gameCode, String gameLetter, int newNumber) {
        Dashboard dashboard = dashboardRepository.findByGameCode(gameCode);
        if (dashboard != null) {
            List<GameLetter> gameLetters = dashboard.getGameLetters();
            if (gameLetters != null) {
                for (GameLetter gameLetterObj : gameLetters) {
                    if (gameLetterObj.getGameLetter().equals(gameLetter)) {
                        gameLetterObj.getGameNumbers().add(newNumber);
                        break;
                    }
                }
                // Save the updated dashboard entity
                dashboardRepository.save(dashboard);
            }
        }
        return dashboard;
    }
}
