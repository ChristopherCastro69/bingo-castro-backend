package com.example.bingocastrobackend.Repository;

import com.example.bingocastrobackend.Model.BingoDashboard;
import com.example.bingocastrobackend.Service.BingoDashboardService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BingoDashboardRepository extends JpaRepository<BingoDashboard, Integer> {
    @Query("SELECT bc FROM BingoDashboard bc WHERE bc.bingoCode = :bingoCode")
    BingoDashboard findByBingoCode(@Param("bingoCode") String bingoCode);


}
