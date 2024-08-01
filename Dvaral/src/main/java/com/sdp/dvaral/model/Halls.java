package com.sdp.dvaral.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

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

    @ElementCollection
    private List<HallImages> hallImagesList;

    @ElementCollection
    private List<HallDetails> hallDetailsList;

    @ElementCollection
    private List<HallAmenities> hallAmenitiesList;

    @ElementCollection
    private List<UserActions> bookmaredHallList;

    @ElementCollection
    private List<UserActions> reservedHallList;

    @ManyToOne
    private Users users;

    @OneToMany(mappedBy = "halls")
    private List<BookingDetails> bookingDetailsList;




}
