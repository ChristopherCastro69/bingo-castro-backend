package com.example.bingocastrobackend.Repository.Dashboard;

import com.example.bingocastrobackend.Model.BingoDashboard;
import com.example.bingocastrobackend.Model.Dashboard.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Integer> {
    @Query("SELECT dash FROM Dashboard dash WHERE dash.gameCode = :gameCode")
    Dashboard findByGameCode(@Param("gameCode") String gameCode);


}
