package com.example.bingocastrobackend.Service;

import com.example.bingocastrobackend.Model.BingoDashboard;
import com.example.bingocastrobackend.Repository.BingoDashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BingoDashboardService {

    @Autowired
    private BingoDashboardRepository bingoDashboardRepository;

    public BingoDashboard createBingoDashboard(BingoDashboard bingoDashboard) {
        return bingoDashboardRepository.save(bingoDashboard);
    }

    public BingoDashboard getBingoDashboardByBingoCode(String bingoCode) {
        return bingoDashboardRepository.findByBingoCode(bingoCode);
    }

    public void addNumberToBingoDashboard(String bingoCode, Integer newNumber) {
        BingoDashboard bingoDashboard = bingoDashboardRepository.findByBingoCode(bingoCode);
        List<Integer> codeNumbers = bingoDashboard.getCodeNumbers();
        codeNumbers.add(newNumber);
        bingoDashboardRepository.save(bingoDashboard);
    }

}
