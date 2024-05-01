package com.example.bingocastrobackend.Controller;

import com.example.bingocastrobackend.Model.BingoDashboard;
import com.example.bingocastrobackend.Service.BingoDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/bingo/dash/")
public class BingoDashboardController {
    @Autowired
    private BingoDashboardService bingoDashboardService;

    @PostMapping("/createGame")
    public BingoDashboard createDashboard(@RequestBody BingoDashboard bingoDashboard) {
        return bingoDashboardService.createBingoDashboard(bingoDashboard);
    }

    @GetMapping("/bCode={bingoCode}")
    public BingoDashboard getBingoDashboard(@PathVariable String bingoCode) {
        return bingoDashboardService.getBingoDashboardByBingoCode(bingoCode);
    }

//    @PostMapping("/addNumber")
//    public void addNumberToBingoDashboard(@RequestBody Map<String, Object> requestBody) {
//        String bingoCode = (String) requestBody.get("bingoCode");
//        Integer newNumber = (Integer) requestBody.get("newNumber");
//        bingoDashboardService.addNumberToBingoDashboard(bingoCode, newNumber);
//
//    }

    @PostMapping("/addNumber")
    public ResponseEntity<String> addNumberToBingoDashboard(@RequestBody Map<String, Object> requestBody) {
        String bingoCode = (String) requestBody.get("bingoCode");
        Integer newNumber = (Integer) requestBody.get("newNumber");
        // Perform addition of number to BingoDashboard
        bingoDashboardService.addNumberToBingoDashboard(bingoCode, newNumber);
        // Return a response indicating success
        return ResponseEntity.status(HttpStatus.OK).body("Number " + newNumber + " added to BingoDashboard with code " + bingoCode);
    }

}
