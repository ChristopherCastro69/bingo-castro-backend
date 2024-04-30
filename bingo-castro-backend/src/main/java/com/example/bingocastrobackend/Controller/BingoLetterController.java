package com.example.bingocastrobackend.Controller;

import com.example.bingocastrobackend.Model.BingoLetter;
import com.example.bingocastrobackend.Service.BingoLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bingo-letter")
public class BingoLetterController {

    @Autowired
    private BingoLetterService bingoLetterService;

    @PostMapping
    public BingoLetter createBingoLetter(@RequestBody BingoLetter bingoLetter) {
        return bingoLetterService.createBingoLetter(bingoLetter);
    }

    @GetMapping("/{id}")
    public BingoLetter getBingoLetterById(@PathVariable int id) {
        return bingoLetterService.getBingoLetterById(id);
    }

    // Other CRUD endpoints for BingoLetter
}
