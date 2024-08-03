package com.sdp.dvaral.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private String hallRating;
    private String hallAddress;
    private String hallContact;
    private int capacity;
    private double hallPrice;

    @OneToMany(mappedBy = "halls")
    private List<HallImages> hallImagesList;

    @ElementCollection
    private List<String> hallAmenitiesList;

    @ManyToMany
    private List<FavoriteHalls> favoriteHallsList;

    @ManyToOne
    private Users users;

    @OneToMany(mappedBy = "halls")
    private List<BookingDetails> bookingDetailsList;




}
