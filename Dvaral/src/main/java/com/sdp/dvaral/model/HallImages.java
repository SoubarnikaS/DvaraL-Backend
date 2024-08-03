package com.sdp.dvaral.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HallImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageID;

    private String imageName;

    @Lob
    @Column(length = 16777215)
    private byte[] data;

    @ManyToOne
    private Halls halls;

    public HallImages(String s) {
    }
}
