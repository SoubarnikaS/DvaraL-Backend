package com.sdp.dvaral.model;

import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class FavoriteHallsIdClass implements Serializable {
    private Users users;
    private Halls hall;
}
