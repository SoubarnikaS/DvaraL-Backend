package com.sdp.dvaral.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    private String userName;
    private String email;
    private String password;
    private String userRole;

    @OneToMany(mappedBy = "users")
    private List<BookingDetails> bookingDetails;

    @OneToMany(mappedBy = "users")
    private List<Reviews> reviews;

    @ManyToMany
    private List<FavoriteHalls> favoriteHalls;



}
