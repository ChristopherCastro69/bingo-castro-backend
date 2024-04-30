package com.example.bingocastrobackend.Model.Version2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardLetters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "gameId",  referencedColumnName = "gameId")
    @JsonIgnore
    private BingoDashboardTest bingoDashboardTest;

    @Column(name = "gameLetter")
    private String gameLetter;

    @ElementCollection
    @CollectionTable(name = "gameLetterNumbers")
    @Column(name = "gameNumber")
    private List<Integer> gameNumbers;

}
