package com.sdp.dvaral.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HallImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageID;

    private String imageName;

    @Lob
    @Column(length = 16777215)
    private byte[] data;

    @ManyToOne
    private Halls halls;
}
