package com.sdp.dvaral.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Halls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hallID;
    private String hallOwner;
    private String hallName;
    private String hallType;
    private String hallLocation;
    private String hallDescription;
    private String hallStatus;
    private Float hallRating;
    private String hallAddress;
    private String hallContact;
    private int capacity;
    private double hallPrice;


    @ElementCollection
    private List<String> hallAmenitiesList;

    @OneToMany(mappedBy = "hall")
    @JsonBackReference
    private List<FavoriteHalls> favoriteHalls;

    @ManyToOne
    private Users users;

    @OneToMany(mappedBy = "halls")
    private List<BookingDetails> bookingDetailsList;




}
