package com.sdp.dvaral.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HallAmenities {
    private boolean wifi;
    private boolean ac;
    private boolean coffee;
    private boolean catering;
}
