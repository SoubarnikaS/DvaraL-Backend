package com.sdp.dvaral.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;

@Embeddable
public class HallImages {

    private String imageName;

    @Lob
    @Column(length = 16777215)
    private byte[] data;
}
