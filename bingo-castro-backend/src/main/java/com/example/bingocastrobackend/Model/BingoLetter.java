package com.example.bingocastrobackend.Model;

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
public class BingoLetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "bingoCardId", referencedColumnName = "bingoCardId")
    @JsonIgnore // Ignore this property during JSON serialization
    private BingoCard bingoCard;

    @Column(name = "letter")
    private String letter;

    @ElementCollection
    @CollectionTable(name = "bingo_letter_numbers")
    @Column(name = "number")
    private List<Integer> numbers;


    // Constructor, Getter and Setter methods

}

