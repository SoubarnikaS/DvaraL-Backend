package com.sdp.dvaral.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@IdClass(FavoriteHallsIdClass.class)
public class FavoriteHalls {

    @ManyToOne
    @Id
    private Users users;

    @ManyToOne
    @Id
    private Halls hall;
}
