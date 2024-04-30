package com.example.bingocastrobackend.Model.Version2;

import com.example.bingocastrobackend.Model.BingoLetter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BingoDashboardTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gameId")
    private int gameId;

    @Column(name = "gameCode")
    private String gameCode;

    @OneToMany(mappedBy = "bingoDashboardTest", cascade = CascadeType.ALL)
    private List<BingoLetter> bingoLetters;
}
