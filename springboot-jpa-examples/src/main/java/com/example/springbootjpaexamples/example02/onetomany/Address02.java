package com.example.springbootjpaexamples.example02.onetomany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Address02 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String detail;
    @ManyToOne
    private User02 user;

}