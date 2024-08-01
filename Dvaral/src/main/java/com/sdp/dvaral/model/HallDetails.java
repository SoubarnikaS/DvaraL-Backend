package com.sdp.dvaral.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HallDetails {

    private String capacity;
    private Double price;
    //use map
    private List<LocalDate> availableDate;
    private List<LocalDateTime> availableTime;

}
