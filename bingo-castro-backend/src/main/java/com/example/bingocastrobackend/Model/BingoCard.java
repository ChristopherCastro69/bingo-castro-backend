package com.example.bingocastrobackend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BingoCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bingoCardId")
    private int bingoCardId;

    @Column(name = "playcardToken")
    private String playcardToken;

    @OneToMany(mappedBy = "bingoCard", cascade = CascadeType.ALL)
    private List<BingoLetter> bingoLetters;

    // Constructor, Getter and Setter methods

//    public int getBingoCardId() {
//        return bingoCardId;
//    }
//
//    public String getPlaycardToken() {
//        return playcardToken;
//    }
//
//    public List<BingoLetter> getBingoLetters() {
//        return bingoLetters;
//    }

//    public void setBingoCardId(int bingoCardId) {
//        this.bingoCardId = bingoCardId;
//    }
//
////    public void setPlaycardToken(String playcardToken) {
////        this.playcardToken = playcardToken;
////    }
//
//    public void setBingoLetters(List<BingoLetter> bingoLetters) {
//        this.bingoLetters = bingoLetters;
//    }
}

