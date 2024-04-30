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
public class BingoDashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dashId")
    private int dashId;

    @Column(name = "bingoCode")
    private String bingoCode;

    @ElementCollection
    @CollectionTable(name = "bingoCodeNumbers")
    @Column(name = "codeNumbers")
    private List<Integer> codeNumbers;


}
