package com.sdp.dvaral.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingID;
    private LocalDateTime bookingDateTime;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String requestedDate;
    private String requestedTime;
    private int noOfGuest;
    private String eventType;
    private String specialRequests;


    @ManyToOne
    private Users users;

    @ManyToOne
    private Halls halls;
}
