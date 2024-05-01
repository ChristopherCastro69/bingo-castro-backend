package com.example.bingocastrobackend.Model.Dashboard;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gameId")
    private int gameId;

    @Column(name = "gameCode")
    private String gameCode;

    @OneToMany(mappedBy = "dashboard", cascade = CascadeType.ALL)
    private List<GameLetter> gameLetters;


}
