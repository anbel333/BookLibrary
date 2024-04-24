package com.anbel.TestBD.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private double rating;
    private boolean takenByUser;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @Override
    public String toString() {
        return "ID: "+id+" Title: "+title+" Author: "+author+" Rating: "+rating;
    }
}
