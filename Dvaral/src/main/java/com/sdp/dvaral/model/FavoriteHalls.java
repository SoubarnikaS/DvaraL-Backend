package com.sdp.dvaral.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class FavoriteHalls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favID;

    private Long userID;
    private Long hallID;

    @ManyToMany
    private List<Users> users;

    @ManyToMany
    private List<Halls> halls;
}
